package bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * 人
 * 类注解写法{@link PeopleXML}
 * 类注解写法{@linkplain PeopleXML}
 * code测试{@code 代码测试}
 *
 * @author starsky
 * @date 2020/03/04
 */
public class People {

    @Value("${}")
    private  String name1;

    /**
     * 的名字
     */
    @Value("${name}")
    public String Name = "Tom";
    // 年龄
    public int age = 25;

    /**
     * 你好
     */
    public int hello = 25;

    public People() {
    }

    /**
     *  构造方法
     * @param name  姓名
     * @param age  年龄
     */
    public People(String name, int age) {
        Name = name;
        this.age = age;
    }

    /**
     *  测试方法
     * @param h 测试方法的参数
     * @return  测试方法的返回值
     */
    public String Test(String h){
        System.out.println("");
        return h;
    }

//    /**
//     *  测试抽象方法
//     */
//    public abstract void  AbstractTest();
}
