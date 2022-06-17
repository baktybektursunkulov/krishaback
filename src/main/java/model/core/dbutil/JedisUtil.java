package model.core.dbutil;

import gs.common.jedis_funcs;
//import envers.MyDefaultRevisionEntity;
import java.io.Serializable;
import redis.clients.jedis.Jedis;

public class JedisUtil implements Serializable {

  public static Jedis getJedis() {
    Jedis res = null;
    
    if (jedis_funcs.getJedisPool() == null) {
      jedis_funcs.initPool(System.getProperty("redis_host"), Integer.valueOf(System.getProperty("redis_port")), System.getProperty("redis_pswd"));
    }
    res = jedis_funcs.getJedisPool().getResource();   

    return res;
  }

}
