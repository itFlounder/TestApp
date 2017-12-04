package com.shsany.testapp.contacts;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by PC on 2017/10/13.
 */

public class PinYinUtils {
    /**
     * 将字符串中的中文转换为拼音，是英文字符则不变
     * @param input
     * @return
     */
    public static String getPinYin(String input){
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String output = "";
        if (input != null && input.length()>0){
            char[] chars = input.trim().toCharArray();
            try{
                for (int i = 0; i < chars.length;i++){
                    if (Character.toString(chars[i]).matches("[\\u4E00-\\u9FA5]+")){
                        String[] temps = PinyinHelper.toHanyuPinyinStringArray(chars[i],format);
                        output += temps[0];
                    }else{
                        output += Character.toString(chars[i]);
                    }
                }
            } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                badHanyuPinyinOutputFormatCombination.printStackTrace();
            }
        }else {
            return "*";
        }
        return output;
    }
}
