package com.coeligena.function.digest;

import java.util.regex.Pattern;

/**
 * answer digest
 * Created by Ellery on 2018/6/22.
 */
public class AnswerDigest {

    /**
     * 对输入的字符串进行截取
     * @param str source string
     * @param width string's byte width
     * @param ellipsis a string added to abbreviate string bottom
     * @return String Object
     */
    private static String abbreviate(String str, int width, String ellipsis) {
        if (str == null || "".equals(str)) {
            return "";
        }
        int d = 0; // byte length
        int n = 0; // char length
        for (; n < str.length(); n++) {
            d = (int) str.charAt(n) > 256 ? d + 2 : d + 1;
            if (d > width) {
                break;
            }
        }
        if (d > width) {
            n = n - ellipsis.length() / 2;
            return str.substring(0, n > 0 ? n : 0) + ellipsis;
        }

        return str.substring(0, n);
    }

    /**
     * 对输入字符的HTML代码进行过滤
     * @param inputString source string
     * @return String Object
     */
    private static String Html2Text(String inputString) {

        // 含html标签的字符串
        String htmlStr = inputString;
        String textStr = "";

        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;

        java.util.regex.Pattern p_html1;
        java.util.regex.Matcher m_html1;

        try {
            // 定义script的正则表达式{或<script[^>]*?>[//s//S]*?<///script>}
            String regEx_script = "<[//s]*?script[^>]*?>[//s//S]*?<[//s]*?///[//s]*?script[//s]*?>";
            // 定义style的正则表达式{或<style[^>]*?>[//s//S]*?<///style>}
            String regEx_style = "<[//s]*?style[^>]*?>[//s//S]*?<[//s]*?///[//s]*?style[//s]*?>";
            // 定义HTML标签的正则表达式
            String regEx_html = "<[^>]+>";
            String regEx_html1 = "<[^>]+";
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            // 过滤script标签
            htmlStr = m_script.replaceAll("");

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            // 过滤style标签
            htmlStr = m_style.replaceAll("");

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            // 过滤html标签
            htmlStr = m_html.replaceAll("");

            p_html1 = Pattern.compile(regEx_html1, Pattern.CASE_INSENSITIVE);
            m_html1 = p_html1.matcher(htmlStr);
            // 过滤html标签
            htmlStr = m_html1.replaceAll("");

            textStr = htmlStr;

        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }

        // 返回文本字符串
        return textStr;
    }

    public static String getDigest(String source, int width, String ellipsis) {
        return abbreviate(Html2Text(source), width, ellipsis);
    }

    public static void main(String[] args) {
        String str = "<p>我认为社交类的产品估值主<body>要基于</body>以<i>下几点：</p><p>1、活跃用户人数，这个是最核心的。</p><p>2、日均用户增长量，这个反应产品的市场反响。</p><p>3、与已被估值的社交平台作对比分析。</p>";
        String slice = getDigest(str, 110, "...");
        System.out.println(slice);
    }
}
