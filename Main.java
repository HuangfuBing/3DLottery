import java.util.Scanner;

abstract class lottery{
	protected int[] winNumber;
	protected int[] userNumber;
	void set_userNumber(int[] userNumber_in) {
		this.userNumber=userNumber_in;
	}
	void set_winNumber(int[] winNumber_in) {
		this.winNumber=winNumber_in;
	}
	abstract int getWinlevel() ;
	int[] createUsernumber(String str) {
		int[] userNumber=new int[3];
		int num=Integer.valueOf(str);
		userNumber[2]=num%10;
		num-=num%10;
		userNumber[1]=(num%100)/10;
		num-=num%100;
		userNumber[0]=num/100;
		return userNumber;
	}
	int[] special(String str) {
		int[] userNumber=new int [3];
		for(int i=0;i<3;i++) {
			if(str.charAt(i)=='*') {
				userNumber[i]=-1;
			}
			else{
				userNumber[i]=Integer.valueOf(str.charAt(i))-48;
			}
		}
		return userNumber;
	}
}

class single extends lottery{
	int getWinlevel() {
		int winSum=0;
		int userSum=0;
		for(int i=0;i<3;i++) {
			winSum+=winNumber[i];
			userSum+=userNumber[i];
		}
		if(winSum==userSum) {
			return 1040;
		}
		else {
			return 0;
		}
	}
}

class sum extends lottery{
	
	int getWinlevel(int num) {
		int winSum=0;
		for(int i=0;i<3;i++) {
			winSum+=winNumber[i];
		}
		if(winSum!=num) {
			return 0;
		}
		else {
			int sum=winSum;
			if(sum==0||sum==27) {
				return 1040;
			}
			if(sum==1||sum==26) {
				return 345;
			}
			if(sum==2||sum==25) {
				return 172;
			}
			if(sum==3||sum==24) {
				return 104;
			}
			if(sum==4||sum==23) {
				return 69;
			}
			if(sum==5||sum==22) {
				return 49;
			}
			if(sum==6||sum==21) {
				return 37;
			}
			if(sum==7||sum==20) {
				return 29;
			}
			if(sum==8||sum==19) {
				return 23;
			}
			if(sum==9||sum==18) {
				return 19;
			}
			if(sum==10||sum==17) {
				return 16;
			}
			if(sum==11||sum==16) {
				return 15;
			}
			if(sum==12||sum==15) {
				return 15;
			}
			if(sum==13||sum==14) {
				return 14;
			}
		}
		return 0;
   }

	int getWinlevel() {
		// TODO Auto-generated method stub
		return 0;
	}
}

class group extends lottery{
	protected int[] groupWin=this.winNumber;
	protected int[] groupUser=this.userNumber;
	int isGroup(int[] winNum) {
		int repeat=-1;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(winNum[i]==winNum[j]&&i!=j) {
					repeat++;
				}
			}
		}
		if(repeat==-1) {
			return 600;
		}
		return repeat;
	}
	int getWinlevel(int repeat1) {
		if(repeat1==600) {
			boolean[] isWin=new boolean[3];
			boolean isWinner=true;
			for(int k=0;k<3;k++) {
				isWin[k]=false;
			}
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(userNumber[i]==winNumber[j]) {
						isWin[i]=true;
					}
				}
			}
			for(int p=0;p<3;p++) {
				if(isWin[p]==false) {
					isWinner=false;
				}
			}
			if(isWinner==false) {
				return 0;
			}
			return 173;
		}
		else {
			int count=0;
			int dif=-1;
			for(int i=0;i<3;i++) {
				if(userNumber[i]==repeat1) {
					count++;
				}
				else {
					dif=userNumber[i];
				}
			}
			if(count==2) {
				for(int j=0;j<3;j++) {
					if(winNumber[j]==dif) {
						return 346;
					}
				}
			}
			else {
				return 0;
			}
		}
		return 0;
	}
	int getWinlevel() {
		// TODO Auto-generated method stub
		return 0;
	}
}

class oned extends lottery{
	boolean isWin=true;

	int getWinlevel() {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++) {
			if(userNumber[i]!=winNumber[i]&&userNumber[i]!=-1) {
				isWin=false;
			}
		}
		if(isWin) {
			return 10;
		}
		return 0;
	}//use -1;
	
}

class towd extends lottery{

	int getWinlevel() {
		// TODO Auto-generated method stub
		boolean isWin=true;
		for(int i=0;i<3;i++) {
			if(userNumber[i]!=winNumber[i]&&userNumber[i]!=-1) {
				isWin=false;
			}
		}
		if(isWin) {
			return 104;
		}
		return 0;
	}
}

class guess1d extends lottery{

	
	int getWinlevel() {
		// TODO Auto-generated method stub
		return 0;
	}
	int getWinlevel(int num) {
		int count = 0;
		for(int i=0;i<3;i++) {
			if(winNumber[i]==num) {
				count++;
			}
		}
		if(count==1) {
			return 2;
		}
		else {
			if(count==2) {
				return 12;
			}
			else if(count==3) {
				return 230;
			}
			else {
				return 0;
			}
		}
	}
}

class general extends lottery{

	int getWinlevel() {
		// TODO Auto-generated method stub
		int prize=0;
		for(int i=0;i<3;i++) {
			if(userNumber[i]==winNumber[i]) {
				prize++;
			}
		}
		if(prize==3) {
			return 470;
		}
		else if(prize==2) {
			return 21;
		}
		return 0;
	}
	
}

class packag extends lottery{

	int ispackage(int[] winNum) {
		int repeat=-1;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(winNum[i]==winNum[j]&&i!=j) {
					repeat++;
				}
			}
		}
		//System.out.print(repeat);
		if(repeat==-1) {
			//System.out.print("hello");
			return 600;
		}
		return 300;
	}
	int getWinlevel() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	int getWinlevel(int repeat) {
		if(repeat==300) {
			int count3=0;
			for(int i=0;i<3;i++) {
				if(userNumber[i]==winNumber[i]) {
					count3++;
				}
			}
			if(count3==3) {
				return 693;
			}
			else {
				count3=0;
				for(int j=0;j<3;j++) {
					for(int k=0;k<3;k++) {
						if(userNumber[j]==winNumber[k]) {
							count3++;
						}
					}
				}
				if(count3==5) {
					return 173;
				}
			}
			return 0;
		}
		if(repeat==600) {
			int count6=0;
			for(int i=0;i<3;i++) {
				if(userNumber[i]==winNumber[i]) {
					count6++;
				}
			}
			if(count6==3) {
				return 606;
			}
			else {
				count6=0;
				for(int j=0;j<3;j++) {
					for(int k=0;k<3;k++) {
						if(userNumber[j]==winNumber[k]) {
							count6++;
						}
					}
				}
				if(count6==3) {
					return 86;
				}
			}
		}
		return 0;
	}
}

class tractor extends lottery{

	int getWinlevel() {
		// TODO Auto-generated method stub
		boolean isUp=true;
		boolean isDown=true;
		for(int i=0;i<2;i++) {
			if(winNumber[i]+1!=winNumber[i+1]) {
				isUp=false;
			}
			if(winNumber[i]!=winNumber[i+1]+1) {
				isDown=false;
			}
		}
		if(isUp||isDown) {
			return 65;
		}
		return 0;
	}
	
}

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] winNumber=new int[3];
		String str3;
		str3=sc.next();//read a word;
		single sing = new single();
		winNumber=sing.createUsernumber(str3);
		int fre=0;
		fre=sc.nextInt();
		String str1;
		String str2="";
		int max=0;
		for(int j=0;j<fre;j++) {
			str1=sc.next();
			//System.out.print(str1);
			//str2=sc.next();
			//System.out.print(str2);
			if(str1.equals("single")) {
				str2=sc.next();
				single sin=new single();
				int[] userNumber=sin.createUsernumber(str2);
				//System.out.print(str2);
				sin.set_winNumber(winNumber);
				sin.set_userNumber(userNumber);
				if(sin.getWinlevel()>max) {
					max=sin.getWinlevel();
				}
			}
			else if(str1.equals("sum")) {
				str2=sc.next();
				int num=Integer.valueOf(str2);
				sum su=new sum();
				su.set_winNumber(winNumber);
				if(su.getWinlevel(num)>max) {
					max=su.getWinlevel(num);
				}
			}
			else if(str1.equals("group")) {
				str2=sc.next();
				group gro = new group();
				int[] userNumber=gro.createUsernumber(str2);
				int repeat=gro.isGroup(userNumber);
				gro.set_userNumber(userNumber);
				gro.set_winNumber(winNumber);
				if(max<gro.getWinlevel(repeat)) {
					max=gro.getWinlevel(repeat);
				}
			}
			else if(str1.equals("oned")) {
				str2=sc.next();
				oned on=new oned();
				int[] userNumber=on.special(str2);
				on.set_userNumber(userNumber);
				on.set_winNumber(winNumber);
				if(on.getWinlevel()>max) {
					max=on.getWinlevel();
				}
			}
			else if(str1.equals("twod")) {
				str2=sc.next();
				towd to = new towd();
				int[] userNumber=to.special(str2);
				to.set_userNumber(userNumber);
				to.set_winNumber(winNumber);
				if(to.getWinlevel()>max) {
					max=to.getWinlevel();
				}
			}
			else if(str1.equals("guess1d")) {
				str2=sc.next();
				guess1d gu = new guess1d();
				int num=Integer.valueOf(str2);
				gu.set_winNumber(winNumber);
				if(gu.getWinlevel(num)>max) {
					max=gu.getWinlevel(num);
				}
			}
			else if(str1.equals("general")){
				str2=sc.next();
				general ge=new general();
				int[] userNumber=ge.createUsernumber(str2);
				ge.set_userNumber(userNumber);
				ge.set_winNumber(winNumber);
				if(ge.getWinlevel()>max) {
					max=ge.getWinlevel();
				}
			}
			else if(str1.equals("package")) {
				str2=sc.next();
				packag pa=new packag();
				int[] userNumber=pa.createUsernumber(str2);
				pa.set_userNumber(userNumber);
				pa.set_winNumber(winNumber);
				int repeat = pa.ispackage(userNumber);
				if(pa.getWinlevel(repeat)>max) {
					max=pa.getWinlevel(repeat);
				}
			}
			else if(str1.equals("tractor")) {
				tractor tr=new tractor();
				tr.set_winNumber(winNumber);
				if(tr.getWinlevel()>max) {
					max=tr.getWinlevel();
				}
			}
		}
		sc.close();
		System.out.print(max);
	}
}
