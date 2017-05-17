package com.vinfai.web.action;

import com.vinfai.cache.DataCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author vinfai
 * @since 2017/5/17
 */
@RestController
public class MyCacheController {

    @Autowired
    private DataCache dataCache;

    @GetMapping("/cache/{id}")
    public String query(@PathVariable Long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) + " : value is " + dataCache.query(id);
    }

    @PutMapping("/cache/{id}")
    public String put(@PathVariable Long id, @RequestParam String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  sdf.format(new Date()) + " : value is " + dataCache.put(id, name) ;
    }

    @DeleteMapping("/cache/{id}")
    public String delete(@PathVariable Long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dataCache.remove(id);
        return sdf.format(new Date()) + " : value is " + dataCache.query(id);
    }

}
