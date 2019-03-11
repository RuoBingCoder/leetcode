package gui_add;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Player {
    public static int[] goals = new int[739];
    public static Player[] p = new Player[738];
    private String num;        //定义球员的总的编号
    private String pnum;       //定义球员在球队中的编号
    private String pname;      //定义球员姓名
    private String ptname;     //定义球员所属球队名称
    private String pgoals;     //定义球员的进球数
    private static String[] s;
    private static ArrayList list;
    public Player() {
        // TODO 自动生成的构造函数存根
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPno(String pnum) {
        this.pnum = pnum;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPtname() {
        return ptname;
    }

    public void setPtname(String ptname) {
        this.ptname = ptname;
    }

    public String getPgoals() {
        return pgoals;
    }

    public void setPgoals(String pgoals) {
        this.pgoals = pgoals;
    }

    @Override
    public String toString() {
        return "Player [num=" + num + ", pnum=" + pnum + ", pname=" + pname + ", ptname=" + ptname + ", pgoals=" + pgoals + "]";
    }

    public Player(String num, String pnum, String pname, String ptname, String pgoals) {
        super();
        this.num = num;
        this.pnum = pnum;
        this.pname = pname;
        this.ptname = ptname;
        this.pgoals = pgoals;
    }

    public static void Load() {   //将球员信息录入到对象数组中
        try {
            FileReader reader = new FileReader("F:\\Demo\\reader.txt");         //创建一个FileReader对象用来读取文件中的字符
            BufferedReader br = new BufferedReader(reader);    //创建一个BufferedReader缓冲对象
            String str;
            for (int j = 0; (str = br.readLine()) != null; j++) {      //按行读取文本文件的信息
                String[] strarray = str.split("\\s+|\\n+");         //把读取到的信息用空格或换行符分开
                p[j] = new Player(strarray[0], strarray[1], strarray[2], strarray[3],
                        strarray[4]);  //把得到的信息放到对象数组中
            }
            br.close();   //关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Get_goals(String matchtime) {    //得到每个球员的进球数
        Load();
        ArrayList<String> list1 = Goal.Choose_players(matchtime);   //从choose函数中得到进球的球员的姓名
        for (int i = 0; i < list1.size(); i++) {
            for (int k = 0; k < p.length; k++) {      //遍历所有球员，如果是进球球员进球数就加一
                if (list1.get(i).equals(p[k].pname)) {
                    goals[k] = Integer.parseInt(p[k].pgoals);
                    goals[k] = goals[k] + 1;
                    p[k].pgoals = String.valueOf(goals[k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Topscorer("7月17日12:00");
    }

    public static ArrayList Topscorer(String matchtime) {    //输出射手榜的信息
        Get_goals(matchtime);
        QuickSort(0, goals.length - 2);    //快速排序
        System.out.println("\n    射手榜\n");
        System.out.println("排名" + "   " + "球员编号" + "    " + "球员姓名" + "      " + "所属球队" + "       " + "进球数\n");
        list=new ArrayList();  //定义一个list
        list.add("排名" + "   " + "球员编号" + "    " + "球员姓名" + "      " + "所属球队" + "       " + "进球数\n");
        for (int m = 0, n = 1; m<=p.length-1; m++, n++) {


            list.add(" " + n + "     " + p[m].pnum + "      " + p[m].pname + "        " + p[m].ptname + "            " + p[m].pgoals);


            System.out.println(" " + n + "     " + p[m].pnum + "      " + p[m].pname + "        " + p[m].ptname + "            " + p[m].pgoals);
        }



            return list;

    }




        public static void QuickSort ( int Left, int Right){ //将射手榜进行快速排序
            int i, j;                     //循环计数变量
            int pivot;                   //枢纽变量
            int temp;                    //暂存变量
            Player temp1;
            i = Left;
            j = Right + 1;
            pivot = goals[Left];
            if (i < j) {
                do {
                    do {
                        i++;
                    } while (goals[i] <= pivot && i <= Right);
                    do {
                        j--;
                    } while (goals[j] >= pivot && j > Left);
                    if (i < j) {
                        temp = goals[i];
                        goals[i] = goals[j];
                        goals[j] = temp;
                        temp1 = p[i];
                        p[i] = p[j];
                        p[j] = temp1;
                    }
                } while (i < j);

                if (i > j) {
                    temp = goals[Left];
                    goals[Left] = goals[j];
                    goals[j] = temp;
                    temp1 = p[Left];
                    p[Left] = p[j];
                    p[j] = temp1;
                }
                QuickSort(Left, j - 1);
                QuickSort(j + 1, Right);
            }
        }
    }
