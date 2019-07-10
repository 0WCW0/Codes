package com.erha.ui;

import com.erha.model.Person;
import com.erha.service.impl.PersonServiceImpl;
import com.erha.util.PersonUtil;

import java.util.Scanner;

public class AppUi {

    Scanner in = new Scanner(System.in);

    PersonServiceImpl psi = new PersonServiceImpl();


    public void getMenu(){

        boolean flag = true;

        System.out.println("\t欢迎使用宿舍管理系统");

            // 初始化
            psi.doInitPerson();

            System.out.println("1.宿舍管理\t2.注销用户\t3.退出软件");
            System.out.println("请选择菜单(1-3):");
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    // 实现宿舍管理
                    getSusheMenu();
                    break;
                case 2:
                    // 返回登录页面

                    break;
                case 3:
                    System.exit(0);
                    break;
            }

    }

    public void getSusheMenu(){
        boolean flag = true;

        while (flag){
            System.out.println("欢迎~欢迎");
            System.out.println("1.增加人员\t2.删除人员\t3.修改人员\t4.单查信息\t5.全查信息\t6.返回上层");
            System.out.println("请选择菜单(1-6):");
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    Person person = new PersonUtil().getPerson("新增");
                    psi.doAddPersonToRoom(person);
                    psi.doPrintAll();
                    break;

                case 2:
                    psi.doDelPersonToRoom();
                    break;

                case 3:
                    psi.doUpdPersonToRoom();
                    break;

                case 4:
                    psi.doSelById();
                    break;

                case 5:
                    psi.doPrintAll();
                    break;

                case 6:
                    getMenu();
                    break;
            }

            System.out.println("是否继续(Y/N):");
            String str = in.next();
            if(str.equals("Y")){
                flag=true;
            }else if(str.equals("N")){
                flag=false;
            }
        }

    }


    public static void main(String[] args) {
        new AppUi().getMenu();
    }

}
