package com.example.cachedemo.service;

import com.example.cachedemo.mapper.CountryMapper;
import com.example.cachedemo.pojo.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"country"})
public class CountryService {

    @Autowired(required = false)
    private CountryMapper countryMapper;


    /**
     *
     * @Cacheable 参数
     * value或者cacheNames 指定缓存名称
     * key 指定缓存key：
     *      缺省情况下，key为为所有参数，前提是用户没有自定义 keyGenerator
     *      可以使用Spring Expression Language (SpEL)，指定key：
     *      1、#root.method, #root.target, and #root.caches for references to the method, target object, and affected cache(s) respectively.
     *      2、Shortcuts for the method name (#root.methodName) and target class (#root.targetClass) are also available.
     *      3、Method arguments can be accessed by index. For instance the second argument can be accessed via #root.args[1], #p1 or #a1. Arguments can also be accessed by name if that information is available.
     *  key = "#root.method.name+'['+#id+']'"
     *
     *  KeyGenerator：自定义KeyGenerator
     *         keyGenerator = "mykeyGenerator"
     *  condition : 可以使用SpEL表达式，建立一个缓存条件，默认情况下都缓存
     *  unless：排除缓存条件（与condition相反操作）
     *  sync：同步缓存（默认不同步），同步情况下有如下限制：
     *  unless() is not supported
     *  Only one cache may be specified
     *  No other cache-related operation can be combined
     *
     *
     * @param id
     * @return
     */

    @Cacheable(condition = "#id>10",unless = "#id==12")
    public Country getCountry(Integer id){
        System.out.println("获取国家信息："+id);
        Country country = countryMapper.selectByPrimaryKey(id);
        System.out.println(country.toString());
        return  country;
    }

    @CachePut(key = "#country.id")
    public Country updateCountry(Country country){
        System.out.println("更新国家信息");
        countryMapper.updateByPrimaryKey(country);
        return country;
    }

    @CacheEvict(beforeInvocation = false,allEntries = true)
    public void deleteCountry(Integer id){
        System.out.println("删除");
        countryMapper.deleteByPrimaryKey(id);
    }

    @Caching(
            cacheable={
                    @Cacheable(key = "#countrycode")
            },
            put = {
                    @CachePut(key = "#result.countryname"),
                    @CachePut(key = "#result.id")
            }
    )
    public Country getCountryByCode(String countrycode){
        System.out.println("查询国家："+countrycode);
        Country country = countryMapper.selectByPrimaryCode(countrycode);
        return country;
    }
}
