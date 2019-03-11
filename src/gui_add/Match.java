package gui_add;
import java.io.*;
import java.util.*;
import java.text.*;

public class Match{
	public static Match[] p1 = new Match[64];
	public static Team [] p3 = new Team[32];
	public String Mnum;     //定义比赛场次
	public String Mtime;    //定义比赛时间
	public String Mgroup;   //定义小组赛
	public String Mteam1;   //定义对战球队
	public String Mgoals1;  //定义球队所得球数
	public String Mteam2;   //定义对战球队
	public String Mgoals2;  //定义球队所得球数
	public String Mscores;  //定义每场赛球队积分比

	public String getMnum() {
		return Mnum;
	}

	public void setMnum(String Mnum) {
		this.Mnum = Mnum;
	}

	public String getMtime() {
		return Mtime;
	}

	public void setMtime(String Mtime) {
		this.Mtime = Mtime;
	}

	public String getMgrope() {
		return Mgroup;
	}

	public void setMgrope(String Mgroup) {
		this.Mgroup = Mgroup;
	}

	public String getMteam1() {
		return Mteam1;
	}

	public void setMteam(String Mteam1) {
		this.Mteam1 = Mteam1;
	}

	public String getMgoals1() {
		return Mgoals1;
	}

	public void setMgoals1(String Mgoals1) {
		this.Mgoals1 = Mgoals1;
	}

	public String getMteam2() {
		return Mteam2;
	}

	public void setMteam2(String Mteam2) {
		this.Mteam2 = Mteam2;
	}

	public String getMgoals2() {
		return Mgoals2;
	}

	public void setMgoals2(String Mgoals2) {
		this.Mgoals2 = Mgoals2;
	}

	public String getMscores() {
		return Mscores;
	}

	public void setMscores(String mscores) {
		Mscores = mscores;
	}

	public Match(String Mnum, String Mtime, String Mgroup, String Mteam1,
				 String Mgoals1, String Mteam2,String Mgoals2,String Mscores) {
		super();
		this.Mnum = Mnum;
		this.Mtime = Mtime;
		this.Mgroup = Mgroup;
		this.Mteam1 = Mteam1;
		this.Mgoals1 = Mgoals1;
		this.Mteam2 = Mteam2;
		this.Mgoals2 = Mgoals2;
		this.Mscores = Mscores;
	}
	@Override
	public String toString() {
		return "Match [Mnum=" + Mnum + ", Mtime=" + Mtime + ", Mgroup=" + Mgroup + ", Mteam1=" +
				Mteam1 + ", "+ "Mgoals1="+ Mgoals1 + ", Mteam2=" + Mteam2+ ", Mgoals2=" +
				Mgoals2+ ", Mscores=" + Mscores +"]";
	}

	public static void load1() {
		try {
			FileReader reader1 = new FileReader("D:\\Demo\\match.txt"); //创建一个FileReader对象用来读取文件中的字符
			BufferedReader br1 =new BufferedReader(reader1);    //创建一个BufferedReader缓冲对象
			String str1;
			for(int i = 0;(str1 = br1.readLine()) != null;i++) {   //按行读取文本文件的信息
				String[] str1array = str1.split("\\s+|\\r+|\\t+|\\n+"); //把读取到的信息用空格或换行符分开
				p1[i] = new Match(str1array[0], str1array[1], str1array[2], str1array[3],
						str1array[4],str1array[5],str1array[6],str1array[7]);   //把得到的信息放到对象数组中
			}
			br1.close();   //关闭文本文件
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static HashSet<String> Save_information(String matchtime,Date begintime) {//存储输入的时间前的每场比赛的信息
		HashSet<String> numset = new HashSet<String>();
		try {
			FileReader reader2 = new FileReader("D:\\Demo\\goalsinformation.txt"); //创建一个FileReader对象用来读取文件中的字符
			BufferedReader br2 =new BufferedReader(reader2);
			DateFormat dateformat = new SimpleDateFormat("MM月dd日HH:mm");  //将时间转换为时间格式
			Date d1,d2;
			try {
				d1 = dateformat.parse(matchtime);   //将输入的时间转换成时间格式
				String arr;
				while((arr = br2.readLine()) != null){   //按行读取每个进球信息文本的信息
					String[] array = arr.split("\\s+|\\r+|\\t+|\\n+");   //把读取到的信息用空格或换行符分开
					d2 = dateformat.parse(array[1]);    //将读取到的每个进球时间转换成时间格式
					if(d2.before(d1) && d2.after(begintime) || d1.equals(d2)) {
						numset.add(array[0]);   //把在时间段内所进球的场次放到numset集合中
						for(int j = 0;j < p1.length;j ++) {  //遍历每场比赛的对象数组，如果是任意球或点球加一个进球数
							if(array[0].equals(p1[j].Mnum)) {   //如果是乌龙球，则对方球队加一个进球数
								if(array[4].equals(p1[j].Mteam1)) {
									if(array[5].equals("任意球")){
										int mgoals1 = Integer.parseInt(p1[j].Mgoals1);
										mgoals1 ++;
										p1[j].Mgoals1 = String.valueOf(mgoals1);
									}
									if(array[5].equals("点球")) {
										int mgoals1 = Integer.parseInt(p1[j].Mgoals1);
										mgoals1 ++;
										p1[j].Mgoals1 = String.valueOf(mgoals1);
									}
									else if(array[5].equals("乌龙球")) {
										int mgoals2 = Integer.parseInt(p1[j].Mgoals2);
										mgoals2 ++;
										p1[j].Mgoals2 = String.valueOf(mgoals2);
									}
									else if(array[5].equals("无球")) {
										int mgoals1 = Integer.parseInt(p1[j].Mgoals1);
										mgoals1 = mgoals1 + 0;
										p1[j].Mgoals1 = String.valueOf(mgoals1);
									}
								}
								if(array[4].equals(p1[j].Mteam2)) {
									if(array[5].equals("任意球")) {
										int mgoals2 = Integer.parseInt(p1[j].Mgoals2);
										mgoals2 ++;
										p1[j].Mgoals2 = String.valueOf(mgoals2);
									}
									if(array[5].equals("点球")) {
										int mgoals2 = Integer.parseInt(p1[j].Mgoals2);
										mgoals2 ++;
										p1[j].Mgoals2 = String.valueOf(mgoals2);
									}
									if(array[5].equals("乌龙球")) {
										int mgoals1 = Integer.parseInt(p1[j].Mgoals1);
										mgoals1 ++;
										p1[j].Mgoals1 = String.valueOf(mgoals1);
									}
									else if(array[5].equals("无球")) {
										int mgoals2 = Integer.parseInt(p1[j].Mgoals2);
										mgoals2 = mgoals2 + 0;
										p1[j].Mgoals1 = String.valueOf(mgoals2);
									}
								}
								int result0 = (p1[j].Mgoals1).compareTo(p1[j].Mgoals2);
								if(result0 > 0) {
									p1[j].Mscores = "3:0";
								}
								else if(result0 < 0) {
									p1[j].Mscores = "0:3";
								}
								else if(result0 == 0) {
									p1[j].Mscores = "1:1";
								}
							}
						}
					}
				}
			}catch(ParseException e) {
				e.printStackTrace();
			}
			br2.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return numset;
	}

	public static void Compare(HashSet<String> numset) {  //通过比较两队的进球数来确定输、赢、平
		p3 = Team.load3();
		Integer temp1,temp2,failure,win,draw,pts1,pts2;
		for(int n = 0;n < numset.size();n++) {
			for(int i = 0;i < p1.length;i ++) {
				if(numset.toArray()[n].equals(p1[i].Mnum)) {
					Integer result1 = Integer.parseInt(p1[i].Mgoals1);
					Integer result2 = Integer.parseInt(p1[i].Mgoals2);
					if(result1 >  result2) {
						for(int j = 0;j < p3.length;j++) {
							if((p3[j].teamname).equals(p1[i].Mteam1)) {
								temp1 = Integer.parseInt(p3[j].teamgoals);
								temp2 = Integer.parseInt(p1[i].Mgoals1);
								temp1 = temp1 + temp2;
								p3[j].teamgoals = String.valueOf(temp1);
								win = Integer.parseInt(p3[j].teamwins);
								win += 1;
								p3[j].teamwins = String.valueOf(win);
								pts1 = Integer.parseInt(p3[j].teampts);
								pts2 = Integer.parseInt(p1[i].Mgoals2);
								pts1 = pts1 + pts2;
								p3[j].teampts = String.valueOf(pts1);
							}
							if((p3[j].teamname).equals(p1[i].Mteam2)){
								temp1 = Integer.parseInt(p3[j].teamgoals);
								temp2 = Integer.parseInt(p1[i].Mgoals2);
								temp1 = temp1 + temp2;
								p3[j].teamgoals = String.valueOf(temp1);
								failure = Integer.parseInt(p3[j].teamfailures);
								failure += 1;
								p3[j].teamfailures = String.valueOf(failure);
								pts1 = Integer.parseInt(p3[j].teampts);
								pts2 = Integer.parseInt(p1[i].Mgoals1);
								pts1 = pts1 + pts2;
								p3[j].teampts = String.valueOf(pts1);
							}
						}
					}
					else if(result1 < result2) {
						for(int k = 0;k < p3.length;k++) {
							if((p3[k].teamname).equals(p1[i].Mteam1)){
								temp1 = Integer.parseInt(p3[k].teamgoals);
								temp2 = Integer.parseInt(p1[i].Mgoals1);
								temp1 = temp1 + temp2;
								p3[k].teamgoals = String.valueOf(temp1);
								failure = Integer.parseInt(p3[k].teamfailures);
								failure += 1;
								p3[k].teamfailures = String.valueOf(failure);
								pts1 = Integer.parseInt(p3[k].teampts);
								pts2 = Integer.parseInt(p1[i].Mgoals2);
								pts1 = pts1 + pts2;
								p3[k].teampts = String.valueOf(pts1);
							}
							if((p3[k].teamname).equals(p1[i].Mteam2)) {
								temp1 = Integer.parseInt(p3[k].teamgoals);
								temp2 = Integer.parseInt(p1[i].Mgoals2);
								temp1 = temp1 + temp2;
								p3[k].teamgoals = String.valueOf(temp1);
								win = Integer.parseInt(p3[k].teamwins);
								win += 1;
								p3[k].teamwins = String.valueOf(win);
								pts1 = Integer.parseInt(p3[k].teampts);
								pts2 = Integer.parseInt(p1[i].Mgoals1);
								pts1 = pts1 + pts2;
								p3[k].teampts = String.valueOf(pts1);
							}
						}
					}
					else if(result1 == result2){
						for(int m = 0;m < p3.length;m++) {
							if(p3[m].teamname.equals(p1[i].Mteam1)) {
								temp1 = Integer.parseInt(p3[m].teamgoals);
								temp2 = Integer.parseInt(p1[i].Mgoals1);
								temp1 = temp1 + temp2;
								p3[m].teamgoals = String.valueOf(temp1);
								draw = Integer.parseInt(p3[m].teamdraws);
								draw += 1;
								p3[m].teamdraws = String.valueOf(draw);
								pts1 = Integer.parseInt(p3[m].teampts);
								pts2 = Integer.parseInt(p1[i].Mgoals2);
								pts1 = pts1 + pts2;
								p3[m].teampts = String.valueOf(pts1);
							}
							if(p3[m].teamname.equals(p1[i].Mteam2)) {
								temp1 = Integer.parseInt(p3[m].teamgoals);
								temp2 = Integer.parseInt(p1[i].Mgoals2);
								temp1 = temp1 + temp2;
								p3[m].teamgoals = String.valueOf(temp2);
								draw = Integer.parseInt(p3[m].teamdraws);
								draw += 1;
								p3[m].teamdraws = String.valueOf(draw);
								pts1 = Integer.parseInt(p3[m].teampts);
								pts2 = Integer.parseInt(p1[i].Mgoals1);
								pts1 = pts1 + pts2;
								p3[m].teampts = String.valueOf(pts1);
							}
						}
					}
				}
			}
		}
		for(int q = 0;q < p3.length;q ++) {  //通过每队的输、赢、平的场数来计算每队的积分、净胜球数、进球数
			Integer scores1 = Integer.parseInt(p3[q].teamscores);
			Integer wins = Integer.parseInt(p3[q].teamwins);
			Integer draws = Integer.parseInt(p3[q].teamdraws);
			Integer failures = Integer.parseInt(p3[q].teamfailures);
			Integer goals1 = Integer.parseInt(p3[q].teamgoals);
			Integer pts4 = Integer.parseInt(p3[q].teampts);
			pts4 = goals1 - pts4;
			p3[q].teampts = String.valueOf(pts4);
			scores1 = wins*3 + draws*1 + failures*0;
			p3[q].teamscores = String.valueOf(scores1);
		}
	}

	public static void Output_scoresboard() {    //输出比赛的积分榜
		int i;
		System.out.println("\n        积分榜 ");
		System.out.println("\n所属组"+"    "+"球队名"+"      "+"赢的场数"+"/"+"平的场数"+"/"+"输的场数"+"   "+"积分");
		System.out.println("\n  A  组\n");
		for(i = 0;i < p3.length;i ++) {
			if((p3[i].groupname).equals("A组"))
				System.out.println(p3[i].groupname+"      "+p3[i].teamname+"        "+p3[i].teamwins+"/"+p3[i].teamdraws+"/"+p3[i].teamdraws+"   "+p3[i].teamscores);
		}
		System.out.println("\n  B  组\n");
		for(i = 0;i < p3.length;i ++) {
			if((p3[i].groupname).equals("B组"))
				System.out.println(p3[i].groupname+"    "+p3[i].teamname+"   "+p3[i].teamwins+"/"+p3[i].teamdraws+"/"+p3[i].teamdraws+"   "+p3[i].teamscores);
		}
		System.out.println("\n  C  组\n");
		for(i = 0;i < p3.length;i ++) {
			if((p3[i].groupname).equals("C组"))
				System.out.println(p3[i].groupname+"    "+p3[i].teamname+"   "+p3[i].teamwins+"/"+p3[i].teamdraws+"/"+p3[i].teamdraws+"   "+p3[i].teamscores);
		}
		System.out.println("\n  D  组\n");
		for(i = 0;i < p3.length;i ++) {
			if((p3[i].groupname).equals("D组"))
				System.out.println(p3[i].groupname+"    "+p3[i].teamname+"   "+p3[i].teamwins+"/"+p3[i].teamdraws+"/"+p3[i].teamdraws+"   "+p3[i].teamscores);
		}
		System.out.println("\n  E  组\n");
		for(i = 0;i < p3.length;i ++) {
			if((p3[i].groupname).equals("E组"))
				System.out.println(p3[i].groupname+"    "+p3[i].teamname+"   "+p3[i].teamwins+"/"+p3[i].teamdraws+"/"+p3[i].teamdraws+"   "+p3[i].teamscores);
		}
		System.out.println("\n  F  组\n");
		for(i = 0;i < p3.length;i ++) {
			if((p3[i].groupname).equals("F组"))
				System.out.println(p3[i].groupname+"    "+p3[i].teamname+"   "+p3[i].teamwins+"/"+p3[i].teamdraws+"/"+p3[i].teamdraws+"   "+p3[i].teamscores);
		}
		System.out.println("\n  G  组\n");
		for(i = 0;i < p3.length;i ++) {
			if((p3[i].groupname).equals("G组"))
				System.out.println(p3[i].groupname+"    "+p3[i].teamname+"   "+p3[i].teamwins+"/"+p3[i].teamdraws+"/"+p3[i].teamdraws+"   "+p3[i].teamscores);
		}
		System.out.println("\n  H  组\n");
		for(i = 0;i < p3.length;i ++) {
			if((p3[i].groupname).equals("H组"))
				System.out.println(p3[i].groupname+"    "+p3[i].teamname+"   "+p3[i].teamwins+"/"+p3[i].teamdraws+"/"+p3[i].teamdraws+"   "+p3[i].teamscores);
		}
	}

	public static void BubbleSort() {    //通过冒泡排序，排积分榜
		int i,j;
		Team temp;
		for(i = 0;i < p3.length - 1;i ++) {
			for(j = 0;j < p3.length - 1 -i;j ++) {
				Integer temp0 = Integer.parseInt(p3[j].teamscores);
				Integer temp1 = Integer.parseInt(p3[j+1].teamscores);
				Integer temp2 = Integer.parseInt(p3[j].teampts);
				Integer temp3 = Integer.parseInt(p3[j+1].teampts);
				Integer temp4 = Integer.parseInt(p3[j].teamgoals);
				Integer temp5 = Integer.parseInt(p3[j+1].teamgoals);
				if(temp0 < temp1) {
					temp = p3[j];
					p3[j] = p3[j+1];
					p3[j+1] = temp;
				}
				if(temp1 == 0) {
					if(temp2 < temp3) {
						temp = p3[j];
						p3[j] = p3[j+1];
						p3[j+1] = temp;
					}
					if(temp2 == temp3) {
						if(temp4 < temp5) {
							temp = p3[j];
							p3[j] = p3[j+1];
							p3[j+1] = temp;
						}
					}
				}
			}
		}
	}

	public static HashSet<String> Knockout8_1() {    //1/8淘汰赛
		DateFormat dateformat = new SimpleDateFormat("MM月dd日HH:mm");
		String date1;
		date1 = "06月29日12:00";
		Date dt0;
		HashSet<String> numset = new HashSet<String>();
		try {
			dt0 = dateformat.parse("06月14日12:00");
			load1();
			numset = Save_information(date1,dt0);  //存储48场比赛的信息并把48场比赛的场次给了numset
			Compare(numset);	    //把这些场次通过比较得出各种加工信息
			BubbleSort();          //进行冒泡排序
			//把每个小组的球队按排序结果放到数组中去
			String []A = new String[4];
			String []B = new String[4];
			String []C = new String[4];
			String []D = new String[4];
			String []E = new String[4];
			String []F = new String[4];
			String []G = new String[4];
			String []H = new String[4];
			for(int i = 0,j = 0;i < p3.length;i++)
				if((p3[i].groupname).equals("A组")) {
					A[j] = p3[i].teamname;
					j++;
				}
			for(int i = 0,j = 0;i < p3.length;i++)
				if((p3[i].groupname).equals("B组")) {
					B[j] = p3[i].teamname;
					j++;
				}
			for(int i = 0,j = 0;i < p3.length;i++)
				if((p3[i].groupname).equals("C组")) {
					C[j] = p3[i].teamname;
					j++;
				}
			for(int i = 0,j = 0;i < p3.length;i++)
				if((p3[i].groupname).equals("D组")) {
					D[j] = p3[i].teamname;
					j++;
				}
			for(int i = 0,j = 0;i < p3.length;i++)
				if((p3[i].groupname).equals("E组")) {
					E[j] = p3[i].teamname;
					j++;
				}
			for(int i = 0,j = 0;i < p3.length;i++)
				if((p3[i].groupname).equals("F组")) {
					F[j] = p3[i].teamname;
					j++;
				}
			for(int i = 0,j = 0;i < p3.length;i++)
				if((p3[i].groupname).equals("G组")) {
					G[j] = p3[i].teamname;
					j++;
				}
			for(int i = 0,j = 0;i < p3.length;i++)
				if((p3[i].groupname).equals("H组")) {
					H[j] = p3[i].teamname;
					j++;
				}
			//把每个小组的前两名球队分别赋给1/8淘汰赛的对战球队
			for(int k = 0;k < p1.length;k ++) {
				if((p1[k].Mnum).equals("49")) {
					p1[k].Mteam1 = A[0];
					p1[k].Mteam2 = B[1];
				}
				if((p1[k].Mnum).equals("50")) {
					p1[k].Mteam1 = C[0];
					p1[k].Mteam2 = D[1];
				}
				if((p1[k].Mnum).equals("51")) {
					p1[k].Mteam1 = B[0];
					p1[k].Mteam2 = A[1];
				}
				if((p1[k].Mnum).equals("52")) {
					p1[k].Mteam1 = D[0];
					p1[k].Mteam2 = C[1];
				}
				if((p1[k].Mnum).equals("53")) {
					p1[k].Mteam1 = E[0];
					p1[k].Mteam2 = F[1];
				}
				if((p1[k].Mnum).equals("54")) {
					p1[k].Mteam1 = G[0];
					p1[k].Mteam2 = H[1];
				}
				if((p1[k].Mnum).equals("55")) {
					p1[k].Mteam1 = F[0];
					p1[k].Mteam2 = E[1];
				}
				if((p1[k].Mnum).equals("56")) {
					p1[k].Mteam1 = H[0];
					p1[k].Mteam2 = G[1];
				}
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return numset;
	}

	public static void Knockout4_1() {           //1/4淘汰赛
		DateFormat dateformat = new SimpleDateFormat("MM月dd日HH:mm");
		String arr[] = new String[8];
		try {
			Date dt1 = dateformat.parse("06月29日12:00");
			Knockout8_1();
			Save_information("7月4日12:00",dt1);  //存储1/4淘汰赛每场比赛的信息
			//把1/8淘汰赛中每场赢得比赛的球队放到数组arr[8]中
			for(int i = 0;i < p1.length;i++) {
				if(p1[i].Mnum.equals("49")) {
					if(p1[i].Mscores == "3:0")
						arr[0] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr[0] = p1[i].Mteam2;
				}
				if(p1[i].Mnum.equals("50")) {
					if(p1[i].Mscores == "3:0")
						arr[1] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr[1] = p1[i].Mteam2;
				}
				if(p1[i].Mnum.equals("51")) {
					if(p1[i].Mscores == "3:0")
						arr[2] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr[2] = p1[i].Mteam2;
				}
				if(p1[i].Mnum.equals("52")) {
					if(p1[i].Mscores == "3:0")
						arr[3] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr[3] = p1[i].Mteam2;
				}
				if(p1[i].Mnum.equals("53")) {
					if(p1[i].Mscores == "3:0")
						arr[4] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr[4] = p1[i].Mteam2;
				}
				if(p1[i].Mnum.equals("54")) {
					if(p1[i].Mscores == "3:0")
						arr[5] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr[5] = p1[i].Mteam2;
				}
				if(p1[i].Mnum.equals("55")) {
					if(p1[i].Mscores == "3:0")
						arr[6] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr[6] = p1[i].Mteam2;
				}
				if(p1[i].Mnum.equals("56")) {
					if(p1[i].Mscores == "3:0")
						arr[7] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr[7] = p1[i].Mteam2;
				}
			}

			//把1/4淘汰赛的对战球队分别给到相应位置
			for(int j = 0;j < p1.length;j++) {
				if(p1[j].Mnum.equals("57")){
					p1[j].Mteam1 = arr[0];
					p1[j].Mteam2 = arr[1];
				}
				if(p1[j].Mnum.equals("58")){
					p1[j].Mteam1 = arr[4];
					p1[j].Mteam2 = arr[5];
				}
				if(p1[j].Mnum.equals("59")){
					p1[j].Mteam1 = arr[2];
					p1[j].Mteam2 = arr[3];
				}
				if(p1[j].Mnum.equals("60")){
					p1[j].Mteam1 = arr[6];
					p1[j].Mteam2 = arr[7];
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Semifinal() {      //半决赛
		DateFormat dateformat = new SimpleDateFormat("MM月dd日HH:mm");
		String arr1[] = new String[4];
		try {
			Date dt1 = dateformat.parse("7月4日12:00");
			Knockout4_1();
			Save_information("7月8日11:00",dt1);

			//把1/4淘汰赛中每场赢得比赛的球队放到数组arr1[4]中
			for(int i = 0;i < p1.length;i++) {
				if(p1[i].Mnum.equals("57")) {
					if(p1[i].Mscores == "3:0")
						arr1[0] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr1[0] = p1[i].Mteam2;
				}
				if(p1[i].Mnum.equals("58")) {
					if(p1[i].Mscores == "3:0")
						arr1[1] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr1[1] = p1[i].Mteam2;
				}
				if(p1[i].Mnum.equals("59")) {
					if(p1[i].Mscores == "3:0")
						arr1[2] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr1[2] = p1[i].Mteam2;
				}
				if(p1[i].Mnum.equals("60")) {
					if(p1[i].Mscores == "3:0")
						arr1[3] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr1[3] = p1[i].Mteam2;
				}
			}

			//把半决赛的对战球队分别给到相应位置
			for(int j = 0;j < p1.length;j++) {
				if(p1[j].Mnum.equals("61")){
					p1[j].Mteam1 = arr1[0];
					p1[j].Mteam2 = arr1[1];
				}
				if(p1[j].Mnum.equals("62")){
					p1[j].Mteam1 = arr1[2];
					p1[j].Mteam2 = arr1[3];
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Knockout4_3() {        //3/4决赛
		DateFormat dateformat = new SimpleDateFormat("MM月dd日HH:mm");
		String arr2[] = new String[2];
		try {
			Date dt1 = dateformat.parse("07月8日12:00");
			Semifinal();
			Save_information("7月12日11:00",dt1);

			//把半决赛中每场赢得比赛的球队放到数组arr2[2]中
			for(int i = 0;i < p1.length;i++) {
				if(p1[i].Mnum.equals("61")) {
					if(p1[i].Mscores == "3:0")
						arr2[0] = p1[i].Mteam2;
					else if(p1[i].Mscores == "0:3")
						arr2[0] = p1[i].Mteam1;
				}
				if(p1[i].Mnum.equals("62")) {
					if(p1[i].Mscores == "3:0")
						arr2[1] = p1[i].Mteam2;
					else if(p1[i].Mscores == "0:3")
						arr2[1] = p1[i].Mteam1;
				}
			}

			//把3/4决赛的对战球队分别给到相应位置
			for(int j = 0;j < p1.length;j++) {
				if(p1[j].Mnum.equals("63")){
					p1[j].Mteam1 = arr2[0];
					p1[j].Mteam2 = arr2[1];
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Final() {       //总决赛
		DateFormat dateformat = new SimpleDateFormat("MM月dd日HH:mm");
		String arr3[] = new String[2];
		try {
			Date dt1 = dateformat.parse("07月14日12:00");
			Knockout4_3();
			Save_information("7月15日11:00",dt1);

			//把3/4决赛中每场赢得比赛的球队放到数组arr3[2]中
			for(int i = 0;i < p1.length;i++) {
				if(p1[i].Mnum.equals("61")) {
					if(p1[i].Mscores == "3:0")
						arr3[0] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr3[0] = p1[i].Mteam2;
				}
				if(p1[i].Mnum.equals("62")) {
					if(p1[i].Mscores == "3:0")
						arr3[1] = p1[i].Mteam1;
					else if(p1[i].Mscores == "0:3")
						arr3[1] = p1[i].Mteam2;
				}
			}

			//把决赛的对战球队分别给到相应位置
			for(int j = 0;j < p1.length;j++) {
				if(p1[j].Mnum.equals("64")){
					p1[j].Mteam1 = arr3[0];
					p1[j].Mteam2 = arr3[1];
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Scoreboard(String matchtime) {   //根据输入时间来输出比赛积分榜
		DateFormat dateformat = new SimpleDateFormat("MM月dd日HH:mm");
		Date d0,d1,d2;
		try {
			d0 = dateformat.parse("06月14日12:00");
			d1 = dateformat.parse(matchtime);
			d2 = dateformat.parse("06月29日12:00");       // 16强决赛
			HashSet<String> numset = new HashSet<String>();
			if((d1.before(d2) && d1.after(d0)) || d1.equals(d2)) {     //48场前的积分榜
				load1();
				numset = Save_information(matchtime,d0);
				Compare(numset);
				BubbleSort();
				Output_scoresboard();
			}
			else if(d1.after(d2)) {     //48场后的积分榜
				load1();
				numset = Save_information("06月29日12:00",d0);
				Compare(numset);
				BubbleSort();
				Output_scoresboard();
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}

	public static void All_match1() { //把所有场次的比赛信息都呈现出来
		DateFormat dateformat= new SimpleDateFormat("MM月dd日HH:mm");
		Date date;
		try {
			date = dateformat.parse("07月15日12:00");
			Final();
			Save_information("7月17日12:00",date);
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}

	public static void Match_result(String matchtime) {//通过输入查询的时间来输出之前所有的比赛结果
		All_match1();
		DateFormat dateformat= new SimpleDateFormat("MM月dd日HH:mm");
		Date date1,date2;
		try {
			date1 = dateformat.parse(matchtime);
			System.out.println("\n    比赛结果\n");
			System.out.println("场次"+" "+"比赛时间"+"        "+"小组赛/淘汰赛"+"         "+"对战球队"+
					"                "+"进球数");
			for(int i = 0;i < p1.length;i++) {
				date2 = dateformat.parse(p1[i].Mtime);
				if(date2.before(date1)) {
					System.out.println(p1[i].Mnum+"  "+p1[i].Mtime+"  "+p1[i].Mgroup+"  "+
							p1[i].Mteam1+"VS"+p1[i].Mteam2+"  "+"           "+p1[i].Mgoals1+":"+p1[i].Mgoals2);
				}
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}

	public static void Match_forecast(String matchtime) {  //通过输入的查询时间来输出之后所有的比赛预告
		All_match1();
		DateFormat dateformat= new SimpleDateFormat("MM月dd日HH:mm");
		Date date1,date2;
		try {
			date1 = dateformat.parse(matchtime);
			System.out.println("\n     比赛预告\n");
			System.out.println("场次"+"     "+"比赛时间"+"              "+"小组赛/淘汰赛"+"          "+
					"对战球队\n");
			for(int i = 0;i < p1.length;i++) {
				date2 = dateformat.parse(p1[i].Mtime);
				if(date2.after(date1)) {
					System.out.println(p1[i].Mnum+"   "+p1[i].Mtime+"    "+p1[i].Mgroup+
							"      "+p1[i].Mteam1+"VS"+p1[i].Mteam2);
				}
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}
	public static void Get_match_information(String matchnum1) {  //输入比赛场次，得到相应的信息
		All_match1();
		System.out.println("场次"+"     "+"比赛时间"+"                    "+"小组赛/淘汰赛"+
				"                  "+"对战球队"+"                 "+"全场总比分");
		for(int i = 0;i < p1.length;i ++) {
			if((matchnum1.equals(p1[i].Mnum))) {
				System.out.println(p1[i].Mnum+"   "+ p1[i].Mtime + "          " +p1[i].Mgroup+"           "+
						p1[i].Mteam1+"VS"+p1[i].Mteam2+"             "+p1[i].Mgoals1+":"+p1[i].Mgoals2);
			}
		}
	}
}
