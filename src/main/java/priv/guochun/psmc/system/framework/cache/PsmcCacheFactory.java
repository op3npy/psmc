package priv.guochun.psmc.system.framework.cache;

import org.springframework.cache.Cache;

/**
 * 自定义缓存工厂类，用于包装获取缓存Cache对象,实际返回的是CacheProxy对象
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:Guochun002@chinasofti.com">guochun</a>
 * @version 1.0
 * @history:
 * Created by guochun 2017-3-10
 */
public interface PsmcCacheFactory
{
    /**
     * 得到系统缓存key=CACHE_SYSTEM的缓存对象
     * <p>Description:<p>
     * @return
     * @author guochun 2017-3-10
     */
    public Cache getCacheSystem();
    

}
