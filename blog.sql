/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2020-09-01 16:33:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bk_articles
-- ----------------------------
DROP TABLE IF EXISTS `bk_articles`;
CREATE TABLE `bk_articles` (
  `article_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '博文ID',
  `user_id` bigint(20) NOT NULL COMMENT '发表用户ID',
  `article_title` text NOT NULL COMMENT '博文标题',
  `article_content` longtext NOT NULL COMMENT '博文内容',
  `article_views` bigint(20) NOT NULL COMMENT '浏览量',
  `article_comment_count` bigint(20) NOT NULL COMMENT '评论总数',
  `article_date` datetime DEFAULT NULL COMMENT '发表时间',
  `article_like_count` bigint(20) NOT NULL,
  `subject_id` bigint(20) NOT NULL COMMENT '分类id',
  `article_type` int(1) NOT NULL COMMENT '是否原创',
  PRIMARY KEY (`article_id`),
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `bk_articles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `bk_users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bk_articles
-- ----------------------------
INSERT INTO `bk_articles` VALUES ('1', '1', 'java\r\n入门到放弃大啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶 顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶', '\r\n                <h2 id=\"section1\">一、关于 <i class=\"serif\">Typo.css</i></h2>\r\n\r\n                <pre><code class=\"language-css\">p { color: red }</code></pre>\r\n\r\n                <pre><code class=\"language-css\">p { color: red }</code></pre>\r\n\r\n                <p><i class=\"serif\">Typo.css</i> 的目的是，在一致化浏览器排版效果的同时，构建最适合中文阅读的网页排版。</p>\r\n                <h4>现状和如何去做：</h4>\r\n\r\n                <p class=\"typo-first\">排版是一个麻烦的问题 <sup><a href=\"#appendix1\"># 附录一</a></sup>，需要精心设计，而这个设计却是常被视觉设计师所忽略的。前端工程师更常看到这样的问题，但不便变更。因为在多个\r\n                    OS 中的不同浏览器渲染不同，改动需要多的时间做回归测试，所以改变变得更困难。而像我们一般使用的\r\n                    Yahoo、Eric Meyer 和 Alice base.css 中采用的 Reset 都没有很好地考虑中文排版。<i class=\"serif\">Typo.css</i>\r\n                    要做的就是解决中文排版的问题。</p>\r\n\r\n                <p><strong><i class=\"serif\">Typo.css</i> 测试于如下平台：</strong></p>\r\n                <table class=\"ui table\" summary=\"Typo.css 的测试平台列表\">\r\n                    <thead>\r\n                    <tr>\r\n                        <th>OS/浏览器</th>\r\n                        <th>Firefox</th>\r\n                        <th>Chrome</th>\r\n                        <th>Safari</th>\r\n                        <th>Opera</th>\r\n                        <th>IE9</th>\r\n                        <th>IE8</th>\r\n                        <th>IE7</th>\r\n                        <th>IE6</th>\r\n                    </tr>\r\n                    </thead>\r\n                    <tbody>\r\n                    <tr>\r\n                        <td>OS X</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>-</td>\r\n                        <td>-</td>\r\n                        <td>-</td>\r\n                        <td>-</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>Win 7</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>-</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>Win XP</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>-</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>Ubuntu</td>\r\n                        <td>✔</td>\r\n                        <td>✔</td>\r\n                        <td>-</td>\r\n                        <td>✔</td>\r\n                        <td>-</td>\r\n                        <td>-</td>\r\n                        <td>-</td>\r\n                        <td>-</td>\r\n                    </tr>\r\n                    </tbody>\r\n                </table>\r\n\r\n                <h4>中文排版的重点和难点</h4>\r\n\r\n                <p>在中文排版中，HTML4 的很多标准在语义在都有照顾到。但从视觉效果上，却很难利用单独的 CSS 来实现，像<abbr title=\"在文字下多加一个点\">着重号</abbr>（例：这里<em\r\n                        class=\"typo-em\">强调一下</em>）。在 HTML4 中，专名号标签（<code>&lt;u&gt;</code>）已经被放弃，而\r\n                    HTML5 被<a href=\"http://html5doctor.com/u-element/\">重新提起</a>。<i class=\"serif\">Typo.css</i>\r\n                    也根据实际情况提供相应的方案。我们重要要注意的两点是：</p>\r\n                <ol>\r\n                    <li>语义：语义对应的用法和样式是否与中文排版一致</li>\r\n                    <li>表现：在各浏览器中的字体、大小和缩放是否如排版预期</li>\r\n                </ol>\r\n                <p>对于这些，<i class=\"serif\">Typo.css</i> 排版项目的中文偏重注意点，都添加在附录中，详见：</p>\r\n                <blockquote>\r\n                    <b>附录一</b>：<a href=\"#appendix1\"><i class=\"serif\">Typo.css</i> 排版偏重点</a>\r\n                </blockquote>\r\n\r\n                <p>目前已有像百姓网等全面使用 <i class=\"serif\">Typo.css</i> 的项目，测试平台的覆盖，特别是在<abbr title=\"手机、平板电脑等移动平台\">移动端</abbr>上还没有覆盖完主流平台，希望有能力的同学能加入测试行列，或者加入到\r\n                    <i class=\"serif\">Typo.css</i>\r\n                    的开发。加入方法：<a href=\"https://github.com/sofish/Typo.css\">参与 <i class=\"serif\">Typo.css</i> 开发</a>。如有批评、建议和意见，也随时欢迎给在\r\n                    Github 直接提 <a\r\n                            href=\"https://github.com/sofish/Typo.css/issues\">issues</a>，或给<abbr\r\n                            title=\"Sofish Lin, author of Typo.css\"\r\n                            role=\"author\">我</abbr>发<a\r\n                            href=\"mailto:sofish@icloud.com\">邮件</a>。</p>\r\n\r\n\r\n                <h2 id=\"section2\">二、排版实例：</h2>\r\n\r\n                <p>提供2个排版实例，第一个中文实例来自于来自于<cite class=\"typo-unique\">张燕婴</cite>的《论语》，由于古文排版涉及到的元素比较多，所以采用《论语》中《学而》的第一篇作为排版实例介绍；第2个来自到经典的\r\n                    Lorem Ipsum，并加入了一些代码和列表等比较具有代表性的排版元素。</p>\r\n\r\n                <h3 id=\"section2-1\">例1：论语学而篇第一</h3>\r\n\r\n                <p>\r\n                    <small><b>作者：</b><abbr title=\"名丘，字仲尼\">孔子</abbr>（\r\n                        <time>前551年9月28日－前479年4月11日</time>\r\n                        ）\r\n                    </small>\r\n                </p>\r\n\r\n                <h4>本篇引语</h4>\r\n\r\n                <p>\r\n                    《学而》是《论语》第一篇的篇名。《论语》中各篇一般都是以第一章的前二三个字作为该篇的篇名。《学而》一篇包括16章，内容涉及诸多方面。其中重点是「吾日三省吾身」；「节用而爱人，使民以时」；「礼之用，和为贵」以及仁、孝、信等道德范畴。 </p>\r\n\r\n                <h4>原文</h4>\r\n\r\n                <p>子曰：「学而时习之，不亦说乎？有朋自远方来，不亦乐乎？人不知，而不愠，不亦君子乎？」 </p>\r\n\r\n                <h4>译文</h4>\r\n\r\n                <p>孔子说：「学了又时常温习和练习，不是很愉快吗？有志同道合的人从远方来，不是很令人高兴的吗？人家不了解我，我也不怨恨、恼怒，不也是一个有德的君子吗？」 </p>\r\n\r\n                <h4>评析</h4>\r\n\r\n                <p>宋代著名学者<u class=\"typo-u\">朱熹</u>对此章评价极高，说它是「入道之门，积德之基」。本章这三句话是人们非常熟悉的。历来的解释都是：学了以后，又时常温习和练习，不也高兴吗等等。三句话，一句一个意思，前后句子也没有什么连贯性。但也有人认为这样解释不符合原义，指出这里的「学」不是指学习，而是指学说或主张；「时」不能解为时常，而是时代或社会的意思，「习」不是温习，而是使用，引申为采用。而且，这三句话不是孤立的，而是前后相互连贯的。这三句的意思是：自己的学说，要是被社会采用了，那就太高兴了；退一步说，要是没有被社会所采用，可是很多朋友赞同<abbr\r\n                        title=\"张燕婴\">我</abbr>的学说，纷纷到我这里来讨论问题，我也感到快乐；再退一步说，即使社会不采用，人们也不理解我，我也不怨恨，这样做，不也就是君子吗？（见《齐鲁学刊》1986年第6期文）这种解释可以自圆其说，而且也有一定的道理，供读者在理解本章内容时参考。\r\n                </p>\r\n\r\n                <p>\r\n                    此外，在对「人不知，而不愠」一句的解释中，也有人认为，「人不知」的后面没有宾语，人家不知道什么呢？当时因为孔子有说话的特定环境，他不需要说出知道什么，别人就可以理解了，却给后人留下一个谜。有人说，这一句是接上一句说的，从远方来的朋友向我求教，我告诉他，他还不懂，我却不怨恨。这样，「人不知」就是「人家不知道我所讲述的」了。这样的解释似乎有些牵强。</p>\r\n\r\n                <p>总之，本章提出以学习为乐事，做到人不知而不愠，反映出孔子学而不厌、诲人不倦、注重修养、严格要求自己的主张。这些思想主张在《论语》书中多处可见，有助于对第一章内容的深入了解。</p>\r\n\r\n                <h3 id=\"section2-2\">例2：英文排版</h3>\r\n\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the\r\n                    industry\'s\r\n                    standard dummy text ever since the 1500s, when an unknown printer took a galley of type and\r\n                    scrambled it to make a\r\n                    type specimen book. It has survived not only five centuries, but also the leap into electronic\r\n                    typesetting, remaining\r\n                    essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets\r\n                    containing Lorem Ipsum\r\n                    passages, and more recently with desktop publishing software like Aldus PageMaker including versions\r\n                    of Lorem\r\n                    Ipsum.</p>\r\n                <blockquote>\r\n                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore\r\n                    et dolore magna\r\n                    aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea\r\n                    commodo consequat.\r\n                </blockquote>\r\n\r\n                <h4>The standard Lorem Ipsum passage, used since the 1500s</h4>\r\n\r\n                <p>\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore\r\n                    et dolore magna\r\n                    aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea\r\n                    commodo consequat.\r\n                    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla\r\n                    pariatur. Excepteur sint\r\n                    occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"</p>\r\n\r\n                <h4>Section 1.10.32 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC</h4>\r\n\r\n                <p>\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium,\r\n                    totam rem aperiam,\r\n                    eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.\r\n                    Nemo enim ipsam\r\n                    voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos\r\n                    qui ratione\r\n                    voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet,\r\n                    consectetur, adipisci\r\n                    velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat\r\n                    voluptatem. Ut enim\r\n                    ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex\r\n                    ea commodi\r\n                    consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil\r\n                    molestiae consequatur,\r\n                    vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\"</p>\r\n\r\n                <h4>List style in action</h4>\r\n                <ul>\r\n                    <li>If you wish to succeed, you should use persistence as your good friend, experience as your\r\n                        reference, prudence as\r\n                        your brother and hope as your sentry.\r\n                        <p>如果你希望成功，当以恒心为良友，以经验为参谋，以谨慎为兄弟，以希望为哨兵。</p>\r\n                    </li>\r\n                    <li>Sometimes one pays most for the things one gets for nothing.\r\n                        <p>有时候一个人为不花钱得到的东西付出的代价最高。</p>\r\n                    </li>\r\n                    <li>Only those who have the patience to do simple things perfectly ever acquire the skill to do\r\n                        difficult things\r\n                        easily.\r\n                        <p>只有有耐心圆满完成简单工作的人，才能够轻而易举的完成困难的事。</p>\r\n                    </li>\r\n                </ul>\r\n\r\n                <h4>You may want to create a perfect <code>&lt;hr /&gt;</code> line, despite the fact that there will\r\n                    never have one\r\n                </h4>\r\n                <hr/>\r\n                <p><abbr title=\"法国作家罗切福考尔德\">La Racheforcauld</abbr> said:\r\n                    <mark>\"Few things are impossible in themselves; and it is often for want of will, rather than of\r\n                        means, that man fails\r\n                        to succeed\".\r\n                    </mark>\r\n                    You just need to follow the browser\'s behavior, and set a right <code>margin</code> to it。it will\r\n                    works nice as the\r\n                    demo you\'re watching now. The following code is the best way to render typo in Chinese:\r\n                </p>\r\n                <pre><code class=\"language-css\">\r\n/* 标题应该更贴紧内容，并与其他块区分，margin 值要相应做优化 */\r\nh1,h2,h3,h4,h5,h6 {\r\n    line-height:1;font-family:Arial,sans-serif;margin:1.4em 0 0.8em;\r\n}\r\nh1{font-size:1.8em;}\r\nh2{font-size:1.6em;}\r\nh3{font-size:1.4em;}\r\nh4{font-size:1.2em;}\r\nh5,h6{font-size:1em;}\r\n\r\n/* 现代排版：保证块/段落之间的空白隔行 */\r\n.typo p, .typo pre, .typo ul, .typo ol, .typo dl, .typo form, .typo hr {\r\n    margin:1em 0 0.6em;\r\n}\r\n</code></pre>\r\n\r\n                <h3 id=\"section3\">三、附录</h3>\r\n\r\n                <h5 id=\"appendix1\">1、<i class=\"serif\">Typo.css</i> 排版偏重点</h5>\r\n                <table class=\"ui table\" summary=\"Typo.css 排版偏重点\">\r\n                    <thead>\r\n                    <tr>\r\n                        <th>类型</th>\r\n                        <th>语义</th>\r\n                        <th>标签</th>\r\n                        <th>注意点</th>\r\n                    </tr>\r\n                    </thead>\r\n                    <tbody>\r\n                    <tr>\r\n                        <th rowspan=\"15\">基础标签</th>\r\n                        <td>标题</td>\r\n                        <td><code>h1</code> ～ <code>h6</code></td>\r\n                        <td>全局不强制大小，<code>.typo</code> 中标题与其对应的内容应紧贴，并且有相应的大小设置</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>上、下标</td>\r\n                        <td><code>sup</code>/<code>sub</code></td>\r\n                        <td>保持与 MicroSoft Office Word 等程序的日常排版一致</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>引用</td>\r\n                        <td><code>blockquote</code></td>\r\n                        <td>显示/嵌套样式</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>缩写</td>\r\n                        <td><code>abbr</code></td>\r\n                        <td>是否都有下划线，鼠标 <code>hover</code> 是否为帮助手势</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>分割线</td>\r\n                        <td><code>hr</code></td>\r\n                        <td>显示的 <code>padding</code> 和 <code>margin</code>正确</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>列表</td>\r\n                        <td><code>ul</code>/<code>ol</code>/<code>dl</code></td>\r\n                        <td>在全局没有 <code>list-style</code>，在 .<code>typo</code> 中对齐正确</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>定义列表</td>\r\n                        <td><code>dl</code></td>\r\n                        <td>全局 <code>padding</code> 和 <code>margin</code>为0， .<code>typo</code> 中对齐正确</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>选项</td>\r\n                        <td><code>input[type=radio[, checkbox]]</code></td>\r\n                        <td>与其他 <code>form</code> 元素排版时是否居中</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>斜体</td>\r\n                        <td><code>i</code></td>\r\n                        <td>只设置一种斜体，让 <code>em</code> 和 <code>cite</code> 显示为正体</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>强调</td>\r\n                        <td><code>em</code></td>\r\n                        <td>在全局显示正体，在 <code>.typo</code> 中显示与 <code>b</code> 和 <code>strong</code> 的样式一致，为粗体</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>加强</td>\r\n                        <td><code>strong/b</code></td>\r\n                        <td>显示为粗体</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>标记</td>\r\n                        <td><code>mark</code></td>\r\n                        <td>类似荧光笔</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>印刷</td>\r\n                        <td><code>small</code></td>\r\n                        <td>保持为正确字体的 80% 大小，颜色设置为浅灰色</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>表格</td>\r\n                        <td><code>table</code></td>\r\n                        <td>全局不显示线条，在 <code>table</code> 中显示表格外框，并且表头有浅灰背景</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>代码</td>\r\n                        <td><code>pre</code>/<code>code</code></td>\r\n                        <td>字体使用 <code>courier</code> 系字体，保持与 <code>serif</code> 有比较一致的显示效果</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <th rowspan=\"5\">特殊符号</th>\r\n                        <td>着重号</td>\r\n                        <td><em class=\"typo-em\">在文字下加点</em></td>\r\n                        <td>在支持 <code>:after</code> 和 <code>:before</code> 的浏览器可以做渐进增强实现</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>专名号</td>\r\n                        <td><u>林建锋</u></td>\r\n                        <td>专名号，有下划线，使用 <code>u</code> 或都 <code>.typo-u</code> 类</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>破折号</td>\r\n                        <td>——</td>\r\n                        <td>保持一划，而非两划</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>人民币</td>\r\n                        <td>&yen;</td>\r\n                        <td>使用两平等线的符号，或者 HTML 实体符号 <code>&amp;yen;</code></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>删除符</td>\r\n                        <td>\r\n                            <del>已删除（deleted）</del>\r\n                        </td>\r\n                        <td>一致化各浏览器显示，中英混排正确</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <th rowspan=\"3\">加强类</th>\r\n                        <td>专名号</td>\r\n                        <td><code>.typo-u</code></td>\r\n                        <td>由于 <code>u</code> 被 HTML4 放弃，在向后兼容上推荐使用 <code>.typo-u</code></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>着重符</td>\r\n                        <td><code>.typo-em</code></td>\r\n                        <td>利用 <code>:after</code> 和 <code>:before</code> 实现着重符</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>清除浮动</td>\r\n                        <td><code>.clearfix</code></td>\r\n                        <td>与一般 CSS Reset 保持一对致 API</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <th rowspan=\"5\">注意点</th>\r\n                        <td colspan=\"3\">（1）中英文混排行高/行距</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td colspan=\"3\">（2）上下标在 IE 中显示效果</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td colspan=\"3\">（3）块/段落分割空白是否符合设计原则</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td colspan=\"3\">（4）input 多余空间问题</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td colspan=\"3\">（5）默认字体色彩，目前采用 <code>#333</code> 在各种浏览显示比较好</td>\r\n                    </tr>\r\n                    </tbody>\r\n                </table>\r\n            </div>', '0', '0', '2020-08-30 19:35:00', '0', '1', '1');
INSERT INTO `bk_articles` VALUES ('3', '1', 'java天下第一', '我真的学裂开了\r\n测试\r\n\r\n\r\n\r\n擦掉撒旦啊\r\n啊\r\n## 按订按订啊大dadadad\r\n\r\n\r\ndadadadadada\r\n###### vasfs\r\n\r\nvs#### \r\nfs\r\n### svsfwefweff\r\ncfafa\r\n\r\n\r\n\r\ngws\r\nfwer\r\n\r\n\r\n\r\n\r\ngwe\r\nrtwer\r\n\r\n\r\n\r\nvs\r\n负个4\r\n2w让q3\r\n\r\n\r\n', '0', '0', '2020-08-30 17:23:06', '0', '1', '1');
INSERT INTO `bk_articles` VALUES ('4', '1', 'dadada', 'dadadadda', '0', '0', '2020-08-31 05:47:59', '0', '2', '1');

-- ----------------------------
-- Table structure for bk_comments
-- ----------------------------
DROP TABLE IF EXISTS `bk_comments`;
CREATE TABLE `bk_comments` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `user_id` bigint(20) NOT NULL COMMENT '发表用户ID',
  `article_id` bigint(20) NOT NULL COMMENT '评论博文ID',
  `comment_like_count` bigint(20) DEFAULT NULL COMMENT '点赞数',
  `comment_date` datetime DEFAULT NULL COMMENT '评论日期',
  `comment_content` text NOT NULL COMMENT '评论内容',
  `parent_comment_id` bigint(20) DEFAULT NULL COMMENT '父评论ID',
  PRIMARY KEY (`comment_id`) USING BTREE,
  KEY `article_id` (`article_id`) USING BTREE,
  KEY `comment_date` (`comment_date`) USING BTREE,
  KEY `parent_comment_id` (`parent_comment_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bk_comments
-- ----------------------------
INSERT INTO `bk_comments` VALUES ('5', '3', '3', '0', '2020-08-31 12:26:05', '大法官法庭是该怂如果恩个额恩个额个恩个e', null);
INSERT INTO `bk_comments` VALUES ('6', '3', '3', '0', '2020-08-31 13:13:27', '啊大苏打热热热我', null);
INSERT INTO `bk_comments` VALUES ('7', '4', '1', '0', '2020-08-31 13:14:43', 'daddasdad', null);

-- ----------------------------
-- Table structure for bk_labels
-- ----------------------------
DROP TABLE IF EXISTS `bk_labels`;
CREATE TABLE `bk_labels` (
  `label_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `label_name` varchar(20) NOT NULL COMMENT '标签名称',
  `label_alias` varchar(15) NOT NULL COMMENT '标签别名',
  `label_description` text NOT NULL COMMENT '标签描述',
  PRIMARY KEY (`label_id`) USING BTREE,
  KEY `label_name` (`label_name`) USING BTREE,
  KEY `label_alias` (`label_alias`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bk_labels
-- ----------------------------

-- ----------------------------
-- Table structure for bk_link
-- ----------------------------
DROP TABLE IF EXISTS `bk_link`;
CREATE TABLE `bk_link` (
  `bk_link_title` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '链接地址的标题',
  `bk_link_url` text COLLATE utf8mb4_bin NOT NULL COMMENT '链接地址',
  `bk_link_type` int(1) NOT NULL COMMENT '那中类型的链接地址',
  PRIMARY KEY (`bk_link_title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of bk_link
-- ----------------------------
INSERT INTO `bk_link` VALUES ('ASCII Generator', 0x687474703A2F2F7777772E6E6574776F726B2D736369656E63652E64652F61736369692F, '1');
INSERT INTO `bk_link` VALUES ('Leetcode', 0x68747470733A2F2F6C656574636F64652D636E2E636F6D2F70726F626C656D7365742F616C6C2F, '0');
INSERT INTO `bk_link` VALUES ('Markdown Nice', 0x68747470733A2F2F6D646E6963652E636F6D2F, '1');
INSERT INTO `bk_link` VALUES ('magicalcoder', 0x687474703A2F2F6C6F77636F64652E6D61676963616C636F6465722E636F6D2F, '1');
INSERT INTO `bk_link` VALUES ('剑指 Offer', 0x68747470733A2F2F7777772E6E6F77636F6465722E636F6D2F74612F636F64696E672D696E7465727669657773, '0');
INSERT INTO `bk_link` VALUES ('沙沙野', 0x68747470733A2F2F7777772E73737965722E636F6D2F, '1');
INSERT INTO `bk_link` VALUES ('百度', 0x7777772E62616964752E636F6D, '1');

-- ----------------------------
-- Table structure for bk_set_artitle_label
-- ----------------------------
DROP TABLE IF EXISTS `bk_set_artitle_label`;
CREATE TABLE `bk_set_artitle_label` (
  `article_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `label_id` bigint(20) NOT NULL,
  PRIMARY KEY (`article_id`) USING BTREE,
  KEY `label_id` (`label_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bk_set_artitle_label
-- ----------------------------

-- ----------------------------
-- Table structure for bk_set_artitle_sort
-- ----------------------------
DROP TABLE IF EXISTS `bk_set_artitle_sort`;
CREATE TABLE `bk_set_artitle_sort` (
  `article_id` bigint(20) NOT NULL COMMENT '文章ID',
  `subject_id` bigint(20) NOT NULL COMMENT '分类ID',
  PRIMARY KEY (`article_id`,`subject_id`),
  KEY `sort_id` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bk_set_artitle_sort
-- ----------------------------

-- ----------------------------
-- Table structure for bk_users
-- ----------------------------
DROP TABLE IF EXISTS `bk_users`;
CREATE TABLE `bk_users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_ip` varchar(20) NOT NULL COMMENT '用户IP',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `user_password` varchar(15) NOT NULL COMMENT '用户密码',
  `user_email` varchar(30) NOT NULL COMMENT '用户邮箱',
  `user_profile_photo` text NOT NULL COMMENT '用户头像',
  `user_registration_time` datetime DEFAULT NULL COMMENT '注册时间',
  `user_birthday` date DEFAULT NULL COMMENT '用户生日',
  `user_age` tinyint(4) DEFAULT NULL COMMENT '用户年龄',
  `user_telephone_number` varchar(11) NOT NULL COMMENT '用户手机号',
  `user_nickname` varchar(20) NOT NULL COMMENT '用户昵称',
  `user_description` text COMMENT '用户介绍',
  `user_keywords` text COMMENT '技能简介',
  `user_github_address` text COMMENT '用户github地址',
  `user_html_title` text COMMENT '首页抬头',
  PRIMARY KEY (`user_id`) USING BTREE,
  KEY `user_name` (`user_name`) USING BTREE,
  KEY `user_nickname` (`user_nickname`) USING BTREE,
  KEY `user_email` (`user_email`) USING BTREE,
  KEY `user_telephone_number` (`user_telephone_number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bk_users
-- ----------------------------
INSERT INTO `bk_users` VALUES ('1', '.0.0.0.', '陈爱全', '1', '1941397037@qq.com', 'https://qqai-blog.oss-cn-beijing.aliyuncs.com/blog/avter/aaa%20%282%29.png', null, '1999-03-01', '0', '18791565713', 'qqai', '99年青年，后端开发者，略懂前端, 学生，实习，缺乏社会的毒打', 'Java,Spring,个人博客，博客', 'https://github.com/Qqqai', 'QQAI');

-- ----------------------------
-- Table structure for bk_user_friends
-- ----------------------------
DROP TABLE IF EXISTS `bk_user_friends`;
CREATE TABLE `bk_user_friends` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识ID',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `user_email` varchar(100) NOT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bk_user_friends
-- ----------------------------
INSERT INTO `bk_user_friends` VALUES ('3', 'qqai', '1941397037@qq.com');
INSERT INTO `bk_user_friends` VALUES ('4', '大二的委屈恶气恶气', '恶趣味去让他去而且');

-- ----------------------------
-- Table structure for bk_user_subject_relation
-- ----------------------------
DROP TABLE IF EXISTS `bk_user_subject_relation`;
CREATE TABLE `bk_user_subject_relation` (
  `subject_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户所展示的科目id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `subject_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户所展示的科目名字',
  `subject_schedule` int(3) DEFAULT NULL COMMENT '用户所展示的科目的学习进度',
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of bk_user_subject_relation
-- ----------------------------
INSERT INTO `bk_user_subject_relation` VALUES ('1', '1', 'java', '80');
INSERT INTO `bk_user_subject_relation` VALUES ('2', '1', '前端', '40');
INSERT INTO `bk_user_subject_relation` VALUES ('3', '1', 'Spring', '60');
INSERT INTO `bk_user_subject_relation` VALUES ('4', '1', 'SpringMVC', '60');
INSERT INTO `bk_user_subject_relation` VALUES ('5', '1', 'Mybatis', '80');
INSERT INTO `bk_user_subject_relation` VALUES ('6', '1', '数据结构与算法', '30');
INSERT INTO `bk_user_subject_relation` VALUES ('8', '1', 'linux', '40');
