package com.wcw.view;

import com.wcw.service.impl.PersonServiceImpl;

import java.util.Scanner;

public class AppUI {
    Scanner in = new Scanner(System.in);
    PersonServiceImpl psi = new PersonServiceImpl();

    public void Menu() {
        boolean flag = true;
        while (flag) {
            //初始化
            psi.doInit();
            //系统提示
            System.out.println("***************欢迎使用系统***************");
            System.out.println("-------1.新增\t2.删除\t3.id查\t4.修改\t5.全查\t6.退出系统-------");
            System.out.print("--------------请选择菜单(1-5):");
            //输入操作
            int a = in.nextInt();
            switch (a) {
                case 1:
                    psi.doAdd();
                    System.out.println();
                    break;
                case 2:
                    psi.doDel();
                    System.out.println();
                    break;
                case 3:
                    psi.doSelById();
                    System.out.println();
                    break;
                case 4:
                    psi.doUpd();
                    System.out.println();
                    break;
                case 5:
                    psi.doPrintAll();
                    System.out.println();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    break;
            }
            System.out.print("是否继续(Y/N):");
            String str = in.next();
            if (str.equals("Y") || str.equals("y")) {
                flag = true;
                System.out.println();
            } else if (str.equals("N") || str.equals("n")) {
                System.exit(0);
            } else {
                System.out.println("输入有误");
                System.exit(0);
            }
        }
    }


    public static void main(String[] args) {
        new AppUI().Menu();
    }


}
