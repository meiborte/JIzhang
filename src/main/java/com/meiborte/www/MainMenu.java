package com.meiborte.www;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author ZhangKaiYuan
 * @Date 2023/9/19 15:20
 */
public class MainMenu {

    //创建集合，存储账户
    static List<Account> accounts = new ArrayList<>();


    //创建一个静态，类加载的时候会第一时间执行，这个静态用来初始化accounts数据
    static{
        accounts.add(
                new Account("吃饭","现金","支出",234.0,"2023-09-18","聚会"));
        accounts.add(
                new Account("工资","交行","收入",4330.0,"2023-10-18","开工资"));
        accounts.add(
                new Account("吃饭","现金","支出",22.0,"2023-08-29","吃饭"));
        accounts.add(
                new Account("衣服","现金","支出",431.0,"2023-09-11","约会"));
        accounts.add(
                new Account("吃饭","现金","支出",24.0,"2023-08-11","聚会"));

    }

    public static void main(String[] args) {
        //iniAccount();

        //获取控制台输入
        Scanner sc = new Scanner(System.in);

        //创建一个flag标志
        boolean flag = true;

        while (flag){
            //给用户展示出菜单
            run();

            int num = sc.nextInt();
            //判断输入的值
            switch (num){
                case 1:
                    addAccount();
                    break;
                case 2:
                    deleteAccount();
                    break;
                case 3:
                    found();
                    int id = sc.nextInt();
                    switch (id){
                        case 1:
                            foundAll();
                            break;
                        case 2:
                            foundTime();
                            break;
                        case 3:
                            foundType();
                    }
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("请重新输入：");
            }
        }
        System.out.println("退出系统");
    }

    //根据支出、收入查询
    private static void foundType() {
        System.out.println("请输入查询类型：1.支出 2.收入");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number == 1) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).sorts == "支出") {
                    Account account = accounts.get(i);
                    System.out.println(i + 1 + "\t" + account.classify + "\t\t" + account.accout + "\t\t"
                            + account.sorts + "\t\t" + account.money + "\t\t" + account.time + "\t\t" + account.remark);
                }
            }
        } else if (number == 2) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).sorts == "收入") {
                    Account account = accounts.get(i);
                    System.out.println(i + 1 + "\t" + account.classify + "\t\t" + account.accout + "\t\t"
                            + account.sorts + "\t\t" + account.money + "\t\t" + account.time + "\t\t" + account.remark);
                }
            }
        }else{
            System.out.println("请输入正确数字");
        }
    }

    //首页菜单
    public static void run(){
        System.out.println("----------------记账本----------------");
        System.out.println("1.添加账务 2.删除账务 3.查询服务 4.退出系统");
        System.out.println("请输入功能序号【1-4】：");
    }

    //三种查询方法
    public static void found(){
        System.out.println("1.查询所有 2.按时间查询 3.按支出入查询");
    }

    //点击查询服务展示所有信息
    public static void foundAll(){
        System.out.println("ID" + "\t" + "类别" + "\t\t" + "账户" + "\t\t" + "类型" + "\t\t"
                + "金额" + "\t\t\t" + "时间" + "\t\t\t\t" + "备注");
        //遍历accounts
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            System.out.println(i+1 + "\t" + account.classify + "\t\t" + account.accout + "\t\t"
                    + account.sorts + "\t\t" + account.money + "\t\t" + account.time + "\t\t" + account.remark);
        }
    }

    //按时间查询
    public static void foundTime(){
        //创建一个时间格式化的对象
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("请输入查询起始时间：");
        Scanner scanner = new Scanner(System.in);
        String BeginTime = scanner.next();
        System.out.println("请输入查询结束时间：");
        String EndTime = scanner.next();

        //使用流筛选出在中间的数
        List<Account> accountList = accounts.stream().filter(account -> {
            String time = account.time;
            //把字符串解析成具体时间
            try {
                Date beginDate = format.parse(BeginTime);
                Date endDate = format.parse(EndTime);
                Date timeDate = format.parse(time);
                if(timeDate.before(endDate) && timeDate.after(beginDate)){
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());//得到一个新得集合
        for (int i = 0; i < accountList.size(); i++) {
            Account account = accountList.get(i);
            System.out.println(i+1 + "\t" + account.classify + "\t\t" + account.accout + "\t\t"
                    + account.sorts + "\t\t" + account.money + "\t\t" + account.time + "\t\t" + account.remark);
        }

    }

    public static void addAccount(){
        System.out.println("请输入类别:");
        Scanner scanner1 = new Scanner(System.in);
        String classify = scanner1.next();
        System.out.println("请输入账户:");
        Scanner scanner2 = new Scanner(System.in);
        String accout = scanner2.next();
        System.out.println("请输入类型:");
        Scanner scanner3 = new Scanner(System.in);
        String sort = scanner3.next();
        System.out.println("请输入金额:");
        Scanner scanner4 = new Scanner(System.in);
        double money = scanner4.nextDouble();
        System.out.println("请输入时间:");
        Scanner scanner5 = new Scanner(System.in);
        String time = scanner5.next();
        System.out.println("请输入备注:");
        Scanner scanner6 = new Scanner(System.in);
        String remark = scanner6.next();

        Account account = new Account();
        account.classify = classify;
        account.accout = accout;
        account.sorts = sort;
        account.money = money;
        account.time = time;
        account.remark = remark;
        accounts.add(account);
    }

    //删除账户
    public static void deleteAccount(){
        System.out.println("请输入需要删除账户id：");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        accounts.remove(id-1);
    }

    public static void storage(){
        //创建一个文件将数据存入
        try {
            File file = new File("D:/java/Java-Study(2023)/记账系统/Account.txt");
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            for (int i = 0; i < accounts.size(); i++) {
                Account ac = accounts.get(i);
                fileWriter.write(ac.classify);
                System.out.print("\t");
                fileWriter.write(ac.accout);
                System.out.print("\t\t");
                fileWriter.write(ac.sorts);
                System.out.print("\t\t");
                fileWriter.write((int)ac.money);
                System.out.print("\t\t");
                fileWriter.write(ac.time);
                System.out.print("\t\t");
                fileWriter.write(ac.remark);
            }
            //fileWriter.write(accounts.toString());
            fileWriter.close();
            System.out.println("创建完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //初始化账户，跟static方式一样
//    public static void iniAccount(){
//        Account account1 = new Account("吃饭","现金","支出",234.0,"2023-09-18","聚会");
//        accounts.add(account1);
//    }
}