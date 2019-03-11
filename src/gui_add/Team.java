package gui_add;
import java.io.*;

public class Team {
	public String groupname;    //定义所属组名
	public String teamname;     //定义球队名称
	public String teamwins;     //定义赢的场数
	public String teamdraws;    //定义平的场数
	public String teamfailures; //定义输的场数
	public String teamgoals;    //定义球队进球数
	public String teampts;      //定义球队净胜球数
	public String teamscores;   //定义球队总积分

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getTeamwins() {
		return teamwins;
	}

	public void setTeamwins(String teamwins) {
		this.teamwins = teamwins;
	}

	public String getTeamdraws() {
		return teamdraws;
	}

	public void setTeamdraws(String teamdraws) {
		this.teamdraws = teamdraws;
	}

	public String getTeamfailures() {
		return teamfailures;
	}

	public void setTeamfailures(String teamfailures) {
		this.teamfailures = teamfailures;
	}

	public String getTeamgoals() {
		return teamgoals;
	}

	public void setTeamgoals(String teamgoals) {
		this.teamgoals = teamgoals;
	}

	public String getTeampts() {
		return teampts;
	}

	public void setTeampts(String teampts) {
		this.teampts = teampts;
	}

	public String getTeamscores() {
		return teamscores;
	}

	public void setTeamscores(String teamscores) {
		this.teamscores = teamscores;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[groupname=");
		builder.append(groupname);
		builder.append(", teamname=");
		builder.append(teamname);
		builder.append(", teamwins=");
		builder.append(teamwins);
		builder.append(", teamdraws=");
		builder.append(teamdraws);
		builder.append(", teamfailures=");
		builder.append(teamfailures);
		builder.append(", teamgoals=");
		builder.append(teamgoals);
		builder.append(", teampts=");
		builder.append(teampts);
		builder.append(", teamscores=");
		builder.append(teamscores);
		builder.append("]");
		return builder.toString();
	}
	public Team(String groupname, String teamname, String teamwins, String teamdraws, String teamfailures,
				String teamgoals,String teampts,String teamscores) {
		super();
		this.groupname = groupname;
		this.teamname = teamname;
		this.teamwins = teamwins;
		this.teamdraws = teamdraws;
		this.teamfailures = teamfailures;
		this.teamgoals = teamgoals;
		this.teampts = teampts;
		this.teamscores = teamscores;
	}

	public Team() {
		// TODO Auto-generated constructor stub
	}

	public static Team[] load3() {     //将球队信息录入到对象数组中
		Team [] p3 = new Team[32];
		try {
			FileReader reader = new FileReader("F:\\Demo\\team.txt"); //创建一个FileReader对象用来读取文件中的字符
			BufferedReader br =new BufferedReader(reader);    //创建一个BufferedReader缓冲对象
			String str;
			for(int j = 0;(str = br.readLine()) != null;j++) {   //按行读取文本文件的信息
				String[] strarray = str.split("\\s+|\\n+");     //把读取到的信息用空格或换行符分开
				p3[j] = new Team(strarray[0], strarray[1], strarray[2], strarray[3],strarray[4],
						strarray[5],strarray[6],strarray[7]);   //把得到的信息放到对象数组中
			}
			br.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return p3;
	}
}
