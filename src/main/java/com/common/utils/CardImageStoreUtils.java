package com.common.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.sys.credit.entity.CardEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bandit
 * @createTime 2022/6/9 9:23
 */
public class CardImageStoreUtils {
    private static final Map<String, String> ImageStore = new HashMap<>();
    public static final String JCB_CARD_GOLD = "JCB_GOLD";
    public static final String JCB_CARD_SILVER = "JCB_SILVER";
    public static final String JCB_CARD_COMMON = "JCB_COMMON";

    public static final String MASTER_CARD_GOLD = "MASTER_GOLD";
    public static final String MASTER_CARD_SILVER = "MASTER_SILVER";
    public static final String MASTER_CARD_COMMON = "MASTER_COMMON";

    public static final String VISA_CARD_GOLD = "VISA_GOLD";
    public static final String VISA_CARD_SILVER = "VISA_SILVER";
    public static final String VISA_CARD_COMMON = "VISA_COMMON";

    public static final String ETC_CARD_COMMON = "ETC_COMMON";
    public static final String ETC_CARD_SILVER = "ETC_SILVER";
    public static final String ETC_CARD_GOLD = "ETC_GOLD";
    public static final String OTHER_CARD = "OTHER_CARD";

    static {
        ImageStore.put(JCB_CARD_GOLD,"https://img.banditblog.top/web-project/jcbgold.gif");
        ImageStore.put(JCB_CARD_SILVER,"https://img.banditblog.top/web-project/JCB%E6%B3%95%E4%BA%BA.gif");
        ImageStore.put(JCB_CARD_COMMON,"https://img.banditblog.top/web-project/JCBw.gif");

        ImageStore.put(MASTER_CARD_GOLD,"https://img.banditblog.top/web-project/mastergold.jpg");
        ImageStore.put(MASTER_CARD_SILVER,"https://img.banditblog.top/web-project/master_1.jpg");
        ImageStore.put(MASTER_CARD_COMMON,"https://img.banditblog.top/web-project/master_2.jpg");

        ImageStore.put(VISA_CARD_GOLD,"https://img.banditblog.top/web-project/visagold.jpg");
        ImageStore.put(VISA_CARD_SILVER,"https://img.banditblog.top/web-project/visa_2.jpg");
        ImageStore.put(VISA_CARD_COMMON,"https://img.banditblog.top/web-project/visa_1.jpg");

        ImageStore.put(ETC_CARD_COMMON,"https://img.banditblog.top/web-project/etc.jpg");
        ImageStore.put(ETC_CARD_SILVER,"https://img.banditblog.top/web-project/etc_2.png");
        ImageStore.put(ETC_CARD_GOLD,"https://img.banditblog.top/web-project/etc_2.png");

        ImageStore.put(OTHER_CARD,"https://img.banditblog.top/web-project/card-img.png");
    }

    public static String transform(CardEntity cardEntity) {
        StringBuilder stringBuilder = new StringBuilder();
        Long publisherId = cardEntity.getCardPublisher();
        Integer goldFlag = cardEntity.getGoldFlag();
        if (publisherId != null && goldFlag != null) {
            if (publisherId == 1) {
                stringBuilder.append("VISA_");
            } else if (publisherId == 2) {
                stringBuilder.append("MASTER_");
            } else if (publisherId == 3) {
                stringBuilder.append("JCB_");
            } else {
                stringBuilder.append("ETC_");
            }
            if (goldFlag == 0) {
                stringBuilder.append("COMMON");
            } else {
                stringBuilder.append("GOLD");
            }
        }
        return stringBuilder.toString();
    }

    public static String getUrl(String key) {
        return ImageStore.get(key);
    }
}
