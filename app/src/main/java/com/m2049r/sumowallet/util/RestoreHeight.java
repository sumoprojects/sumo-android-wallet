/*
 * Copyright (c) 2018 m2049r
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.m2049r.sumowallet.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import timber.log.Timber;

public class RestoreHeight {
    static private RestoreHeight Singleton = null;

    static public RestoreHeight getInstance() {
        if (Singleton == null) {
            synchronized (RestoreHeight.class) {
                if (Singleton == null) {
                    Singleton = new RestoreHeight();
                }
            }
        }
        return Singleton;
    }

    private Map<String, Long> blockheight = new HashMap<>();

    RestoreHeight() {
        blockheight.put("2017-05", 6000L);
        blockheight.put("2017-06", 17000L);
        blockheight.put("2017-07", 24000L);
        blockheight.put("2017-08", 35000L);
        blockheight.put("2017-09", 45000L);
        blockheight.put("2017-10", 55000L);
        blockheight.put("2017-11", 66000L);
        blockheight.put("2017-12", 76000L);
        blockheight.put("2018-01", 87000L);
        blockheight.put("2018-02", 98000L);
        blockheight.put("2018-03", 107000L);
        blockheight.put("2018-04", 116000L);
        blockheight.put("2018-05", 126000L);
        blockheight.put("2018-06", 137000L);
        blockheight.put("2018-07", 169000L);
        blockheight.put("2018-08", 180000L);
        blockheight.put("2018-09", 191000L);
        blockheight.put("2018-10", 202000L);
        blockheight.put("2018-11", 213000L);
        blockheight.put("2018-12", 223000L);
        blockheight.put("2019-01", 235000L);
        blockheight.put("2019-02", 246000L);
        blockheight.put("2019-03", 256000L);
        blockheight.put("2019-04", 267000L);
        blockheight.put("2019-05", 278000L);
        blockheight.put("2019-06", 289000L);
        blockheight.put("2019-07", 300000L);
        blockheight.put("2019-08", 311000L);
        blockheight.put("2019-09", 322000L);
        blockheight.put("2019-10", 333000L);
        blockheight.put("2019-11", 344000L);
        blockheight.put("2019-12", 355000L);
        blockheight.put("2020-01", 366000L);
        blockheight.put("2020-02", 377000L);
        blockheight.put("2020-03", 387500L);
        blockheight.put("2020-04", 398500L);
        blockheight.put("2020-05", 409300L);
        blockheight.put("2020-06", 420400L);
        blockheight.put("2020-07", 431100L);
        blockheight.put("2020-08", 442300L);
        blockheight.put("2020-09", 453400L);
        blockheight.put("2020-10", 464150L);
        blockheight.put("2020-11", 475270L);
        blockheight.put("2020-12", 486050L);
        blockheight.put("2021-01", 497200L);        
    }
    long latestHeight = 497200L;

    public long getHeight(final Date date) {
        Timber.d("Restore Height date %s", date);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Timber.d("Restore Height cal %s", cal);

        if (cal.get(Calendar.YEAR) < 2017)
            return 0;
        // Month is 0 based
        // https://stackoverflow.com/a/7183009
        if ((cal.get(Calendar.YEAR) == 2018) && ((cal.get(Calendar.MONTH) + 1) <= 3))
            // before Apr 2017
            return 0;

       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");

        String queryDate = formatter.format(date);
        Timber.d("String query date %s", queryDate);

        long height = 0;
        if (blockheight.get(queryDate) == null) {
            height = latestHeight;
        } else {
            height = blockheight.get(queryDate);
        }
        return height;
    }
}
