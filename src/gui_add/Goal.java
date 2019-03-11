package gui_add;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.*;

class Goal extends Player {
	public static Goal [] p2 = new Goal[197];
	private String mnum;          //定义比赛场次
	private String goaltime;      //定义进球的时间
	private String playernum;     //定义球员编号
	private String playername;    //定义球员姓名
	private String tname;         //定义球员所属球队的名称
	private String goalattribution;    //定义球员所进球属于什么球


	public String getGoaltime() {
		return goaltime;
	}


	public void setGoaltime(String goaltime) {
		this.goaltime = goaltime;
	}


	public String getPlayernum() {
		return playernum;
	}


	public void setPlayernum(String playernum) {
		this.playernum = playernum;
	}


	public String getPlayername() {
		return playername;
	}


	public void setPlayername(String playername) {
		this.playername = playername;
	}


	public String getTname() {
		return tname;
	}


	public void setTname(String tname) {
		this.tname = tname;
	}


	public String getGoalattribution() {
		return goalattribution;
	}


	public void setGoalattribution(String goalattribution) {
		this.goalattribution = goalattribution;
	}


	public Goal(String mnum, String goaltime, String playernum, String playername,
				String tname, String goalattribution) {
		super();
		this.mnum = mnum;
		this.goaltime = goaltime;
		this.playernum = playernum;
		this.playername = playername;
		this.tname = tname;
		this.goalattribution = goalattribution;
	}
	@Override
	public String toString() {
		return "Goalinformation [mnum=" + mnum + ", goaltime=" + goaltime +
				", playernum=" + playernum + ", playername=" + playername +
				",tname=" + tname + ", goalattribution=" + goalattribution + "]";
	}


	public static String[] load2() {    //将每个进球信息录入到对象数组中
		String[] str2array = new String[6];
		try {
			FileReader reader2 = new FileReader("F:\\Demo\\goalsinformation.txt"); //创建一个FileReader对象用来读取文件中的字符
			BufferedReader br2 =new BufferedReader(reader2);    //创建一个BufferedReader缓冲对象
			String str2;
			for(int i = 0;(str2 = br2.readLine()) != null;i++) {  //按行读取文本文件的信息
				str2array = str2.split("\\s+|\\r+|\\t+|\\n+");    //把读取到的信息用空格或换行符分开
				p2[i] = new Goal(str2array[0], str2array[1], str2array[2],
						str2array[3],str2array[4],str2array[5]);    //把得到的信息放到对象数组中
			}
			br2.close();   //关闭文本文件
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str2array;
	}

	public static ArrayList<String> Choose_players(String matchtime) {  //选择队员的名字
		load2();
		ArrayList<String> list = new ArrayList<String>();
		DateFormat dateformat = new SimpleDateFormat("MM月dd日HH:mm");
		Date d1,d2;
		try {
			d1 = dateformat.parse(matchtime);
			for(int j = 0;j < p2.length;j ++) {
				d2 = dateformat.parse(p2[j].goaltime);
				if(d2.before(d1)) {
					if(p2[j].goalattribution.equals( "任意球") ||
							p2[j].goalattribution.equals( "点球"))
						list.add(p2[j].playername);    //将进球队员的名字放到list集合中
				}
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void Get_goals_information(String matchnum1) {  //输出每场比赛的每个进球的信息
		load2();
		System.out.println("\n进球时间"+"                "+"所属球队"+"            "+
				"队员编号"+"         "+"队员姓名"+"       "+"进球\n");
		for(int i = 0;i < p2.length;i ++) {
			if((matchnum1.equals(p2[i].mnum))) {
				System.out.println(p2[i].goaltime+"   "+ p2[i].tname + "     " + p2[i].playernum +
						"      " + p2[i].playername + "        " + p2[i].goalattribution);
			}
		}
	}
}


