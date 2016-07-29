package com.forerunner.foundation.service.system;

import java.io.UnsupportedEncodingException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.forerunner.foundation.facade.system.RedisFacadeService;

@Service("redisService")
public class RedisService implements RedisFacadeService {

	private static String redisCode = "utf-8";

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	
	public StringRedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public Long del(final String... keys) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				long result = 0;
				for (String key : keys) {
					result = connection.del(key.getBytes());
				}
				return result;
			}
		});
	}

	@Override
	public void set(final byte[] key, final byte[] value, final long liveTime) {
		redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set(key, value);
				if (liveTime > 0) {
					connection.expire(key, liveTime);
				}
				return 1L;
			}
		});
	}

	@Override
	public void set(String key, String value, long liveTime) {
		this.set(key.getBytes(), value.getBytes(), liveTime);
	}

	@Override
	public void set(String key, String value) {
		this.set(key, value, 0);
	}

	@Override
	public void set(byte[] key, byte[] value) {
		this.set(key, value, 0);
	}

	@Override
	public String get(final String key) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					return new String(connection.get(key.getBytes()), redisCode);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return "";
			}
		});
	}

	@Override
	public boolean exists(final String key) {
		redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					return new String(connection.get(key.getBytes()), redisCode);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return "";
			}
		});
		return false;
	}

	@Override
	public boolean flush() {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.flushDb();
				return true;
			}
		});
	}

	@Override
	public long size() {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {				
				return connection.dbSize();
			}			
		});
	}

	@Override
	public String ping() {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.ping();
			}	
		});
	}

	@Override
	public Set<String> keys(String pattern) {
		return redisTemplate.keys(pattern);
	}

}
