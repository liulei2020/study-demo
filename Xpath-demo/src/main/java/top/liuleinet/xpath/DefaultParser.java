package top.liuleinet.xpath;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * @classname: DefaultParser
 * @author: lei.liu
 * @description:
 * @date: 2022/11/11
 * @version: v1.0
 **/
public class DefaultParser {
    public static void main(String[] args) throws Exception {
        //构建 DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("D:\\Codeeeee\\Study\\Xpath-demo\\src\\main\\java\\top\\liuleinet\\xpath\\inventory.xml");

        //创建 XPath
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();

        System.out.println("=====>获取写于2001年以后的书的标题");

        XPathExpression expr = xpath.compile("//book[@year>2001]/title/text()");
        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

        System.out.println("=====>获取写于2001年以前的书的标题");

        expr = xpath.compile("//book[@year<2001]/title/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

        System.out.println("=====>获取售价小于37元的书的标题");

        expr = xpath.compile("//book[price<37]/title/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

        System.out.println("=====>获取售价大于37元的书的标题");

        expr = xpath.compile("//book[price>37]/title/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

        System.out.println("=====>获取第一个book节点的书的标题");

        expr = xpath.compile("//book[1]/title/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

        System.out.println("=====>获取最后一个book节点的书的标题");

        expr = xpath.compile("//book[last()]/title/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

        System.out.println("=====>获取所有作者");

        expr = xpath.compile("//book/author/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

        System.out.println("=====>获取所有标题节点的数量");

        expr = xpath.compile("count(//book/title)");
        result = expr.evaluate(doc, XPathConstants.NUMBER);
        Double count = (Double) result;
        System.out.println(count.intValue());

        System.out.println("======>获取书作者姓名以曹为开始的书的标题");

        expr = xpath.compile("//book[starts-with(author,'曹')]");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i)
                    .getChildNodes()
                    .item(1)
                    .getTextContent());
        }

        System.out.println("=====>获取书作者姓名包含“中”的书的标题");

        expr = xpath.compile("//book[contains(author,'中')]");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i)
                    .getChildNodes()
                    .item(1)
                    .getTextContent());
        }

        System.out.println("=====>获取作者为“吴承恩”的书的标题");

        expr = xpath.compile("//book[author='吴承恩']/title/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

        System.out.println("=====>获取作者为“吴承恩”的书的数量\"");

        expr = xpath.compile("count(//book[author='吴承恩'])");
        result = expr.evaluate(doc, XPathConstants.NUMBER);
        count = (Double) result;
        System.out.println(count.intValue());

        System.out.println("=====>获取注释 ");

        expr = xpath.compile("//inventory/comment()");
        result = expr.evaluate(doc, XPathConstants.STRING);
        String comment = (String) result;
        System.out.println(comment);
    }
}