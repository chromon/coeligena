package com.coeligena.function.digest;

import java.util.regex.Pattern;

/**
 * answer digest
 * Created by Ellery on 2018/6/22.
 */
public class ContentDigest {

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
        String str = "<p>测试回答测试回答测试回答测试回答测试回答测试回答测试回答测试回答测试回答测试回答测试回答测试回答测试回答测试回答测试回答测试回答测试回答测试回答</p><p>作者：BenderRodriguez\n" +
                "链接：https://www.zhihu.com/question/269693413/answer/351259893\n" +
                "来源：知乎\n" +
                "著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。\n" +
                "\n" +
                "5。芬兰数学家、菲尔兹奖得主阿尔福斯说自己不相信物理学，“因为物理学家离数学那么近, 他们却不懂得数学“。当有人说弦论学家用到很多数学时, 阿尔福斯毫不留情地指出弦论是错误的理论，而且他觉得真正的数学家不应该从物理学中获得灵感。6。苏俄数学家博格留博夫有一次遇到一个民科，他耐心地听完对方冗长的介绍之后，微笑着说，你这属于理论物理研究的范围 —— 我不是这方面的专家，但楼下的朗道院士对这个方面很感兴趣，他是你该找的人。7。法国数学家、菲尔兹奖得主阿兰·克尼斯认为物理学家是群功利之徒。他讲过一个故事：96年, 我在芝加哥大学物理系讲过一个报告，一个知名的物理学家听了几分钟就退场了。两年之后, 我在牛津大学作了一模一样的报告。 这次， 这个家伙又在场，但他不仅听完了我的报告，还对它赞赏有加。我于是私下里问他为什么。他说，因为最近有人看到维藤在普林斯顿图书馆翻阅你的著作！8。有人告诉费曼说，霍金是个天才，他能够心算路径积分。费曼说，那不算什么，能提出路径积分才是真的屌。9。德国数学家哥德尔跟爱因斯坦在普林斯顿时经常一起就伴上下班。爱因斯坦私下对人说，自己的工作不再重要，他去高研院上班的唯一目的是和歌德尔就伴回家。10。不少物理学家，像是爱因斯坦、狄拉克和杨振宁都相信大自然具有数学式的简洁美。詹姆斯·金斯曾说过，上帝是个纯粹数学家！而诺贝尔奖得主温伯格一边写下一个带13个指标的张量一边表示反对，说自然界是复杂而丑陋的 —— 事实上，有一整个领域，就是基于这个信念建立起来的。11。狄拉克一生追求数学美，他晚年认为重整化处理无穷大发散的方式背离了数学原则，因而反对量子场论。他说，积分截断会破坏了相对论不变性，这是个很严重的物理问题。然而比起数学问题来，物理困难还要小的多。狄拉克因此被主流物理学界所驱逐。上文的温伯格认为狄拉克相信简洁美是限制其后半生创造力的悲剧。12。泡利和爱丁顿在晚年迷信精细结构常数  。爱丁顿曾认为  。后来实验结果表明  更接近于1/137.036，爱丁顿便把他的理论修正为  。有人因此戏称他为，爱丁玩爵士 (Sir Adding-One)。13。数学家：你方程里的这几个量分别是什么？物理学家：都是算符：D是微分算符，U是幺正算符，S是旋量算符。数学家：这几个符号表示什么？物理学家：都是函数：  是标量函数，  是德欧塔函数，  是分布函数，  是波函数。数学家：  也是函数？物理学家：不，  是个场。14。某年某月某日，杨振宁与丘成桐辩论大型加速器。物理学家、诺贝尔奖得主杨振宁说，应该放弃建设新的加速器，转而去研究数学。数学家、菲尔兹奖得主丘成桐说，应该建加速器，以便研究新的物理。从来不灌水的生物学家施一公插嘴说，21世纪是生物的世纪 …… 大家都来搞生物吧。15。物理学家：我的理论能解释1.4TeV信号的反常。数学家：咦，这个反常不是已经被实验家否决了吗？物理学家：是的，所以我又发表了一个理论解释它为什么不存在。16。数学家：证明黎曼猜想的努力再次失败了。物理学家：我们距离商用量子计算机至多5年。17。物理学家猜一个解，这个过程叫做某某ansatz,如果即使猜这个解也很复杂，该过程就叫做某某approach或某某method,如果猜这个解还能讲出点道理来，该过程叫做某某theory,如果一类问题都可以这么猜，该过程就叫做某某formalism或某某principle，如果某个人猜出的解是错的，该情况就叫做anomaly，如果很多人猜出的解是错的，该情况就叫做breaking。18。物理学家用如下方法证明命题A：假定A成立，则可以推出B，B看起来是显然的，所以A是正确的。19。计算物理其实是宗教:它由很多分支组成，分支之间是由于细微的差别分裂于某个更大的学派，各个分支之间，互不交往；它们在很久之前由现已封神的人建立，即使此人的兴趣早已转移;它们最初建立时是出于某个伟大的目标，现在尽管明知那个目标已经不再可能实现，执掌学派的大佬们仍然固执地维护着它，因为这是他们唯一会的东西；凡是相信其他竞争方法的人都是异教徒，在任何场合必须抓住一切机会羞辱他们；由很多学派外的人不关心的文章，而且文章的数目还在增加；有一套宏大的学说，为迷茫的年轻人提供心灵庇护；寻求国家资助，同时强调学术自由。20。数学遇到一个方程无法求解，来请物理学家帮忙。第二天，物理学家找到她说，问题已经解决了，但我的方法仅适用于真空各向同性的球形方程。21。数学家问一个物理学家，97是不是质数。物理学家看了一下自己的手机说，97是质数。过了一会，数学家返回来说，请再想想。物理学家又看了一下自己的手机说，97不是质数。又过了一会，数学家再次返回来说，请再考虑一下。物理学家最后看了一眼自己的手机说，对不起，这个问题有争议，相关页面已经被锁定。22。一个物理学家发现，奇数都是质数。他找来两个学生来做实验验证。学生A找来20以内所有的奇数，他发现 9，15不是质数。他和导师在PRL上发了篇文章，声称在10%的误差范围内奇数都是质数。学生A毕业以后，学生B接过他的工作，继续研究。她找来100以内的质数，发现只有25个。于是她和导师写了篇文章说，奇数都是质数这个结论是正确的，不过在使用的时候，需要乘以一个蒙混因子(fudge factor)。23。数学家说，所有的数学定理都是对的，只不过有一些更有用些；物理学家说，所有的物理模型都是错的，只不过有一些更有用些。24。数学家说，一个数学家就是一台机器，将咖啡转化成定理；物理学家说，一个物理学家就是一台机器，将咖啡转化成ppt。25。一个物理学家见到一个数学家，他开口问道：我这里有个积分你会积吗？26。一个物理学家写了10篇文章，被引用了45次。27。数学家说无理数比有理数多。物理学家反对说，可是大多数数都是有理数啊。</p>";
        String slice = "<p>" + getDigest(str, 150, "...") + "<p>";
        System.out.println(slice);
    }
}
