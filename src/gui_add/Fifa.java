package gui_add;
import java.util.*;
public class Fifa{

	public static void main(String[] args) {
		while(true){
			User_interface.Menu();      //打印出菜单
			Scanner input = new Scanner(System.in);
			int option = input.nextInt();
			switch(option) {
				case 1:
					System.out.println("请输入查询的比赛的时间（比如:6月14日23:00)");
					String matchtime = input.next();  // 输入比赛时间
					Match.Match_result(matchtime);        //输出比赛结果
					Player.Topscorer(matchtime);          //输出射手榜
					Match.Scoreboard(matchtime);          //输出积分榜
					Match.Match_forecast(matchtime);      //输出比赛预告
					break;
				case 2:
					System.out.println("请输入查询的场次");
					String matchnum = input.next();     //输入比赛场次
					Match.Get_match_information(matchnum);  //输出比赛信息
					Goal.Get_goals_information(matchnum);  //输出进球信息
					break;
				case 3:
					System.out.println("请输入你要写的评论,输入#结束");
					Comment.writeComment();
					break;
				case 4:
					System.exit(0);
			}
			System.out.println("是否继续查询:yes or no?");
			String str = input.next();
			if(str.equals("no")) {
				input.close();
				System.exit(0);
			}
		}
	}
}
