import java.util.Scanner;

public class Bus extends Main {
    int inPeople=0;
    int maxPeople=30;
    int cost=1000;
    int busNum = 1;
    int gas;
    int speed;
    String state = "운행";

    Bus(int gas, int speed) {
        this.gas = gas;
        this.speed = speed;
    }
    public void bus1() {

    }

    public void bus2(String str) {
        this.state = str;
        if(this.state.equals("차고지")||this.state.equals("차고지행")){
            System.out.println("상태 : " + str + "\n주유량 : " + this.gas);
            this.gas=100;
            this.inPeople = 0;
            this.maxPeople = 30;
        }
    }

    public void bus3(int i) {
        if(this.maxPeople-i>=0) {
            this.inPeople += i;
            this.maxPeople -= i;
            System.out.println("\n탑승 승객 수 : " + this.inPeople + "\n잔여 승객 수 : " + this.maxPeople + "\n요금 확인 : " + this.cost*i);
        }else{
            System.out.println("최대 승객 수 초과");
        }
    }

    public void bus4(int i) {
        this.speed += i;
    }

    public void bus5(int i) {
        if(this.gas + i >=0) {
            this.gas += i;
            if(this.gas<10){
                this.state = "차고지행";
                this.gas=100;
                this.inPeople = 0;
                this.maxPeople = 30;
                System.out.println("\n주유량 : " + this.gas + "\n상태 : " + this.state);
                System.out.println("\n주유가 필요합니다.");
            }else{
                System.out.println("\n주유량 : " + this.gas);
            }
        }else{
            System.out.println("기름이 부족합니다.");
        }
    }
    public void bus() {
        Scanner scan = new Scanner(System.in);

        int i;
        int choose = 1;
        String str;
        System.out.println("\n버스 정보 \n승객수 : " + this.inPeople);
        System.out.println("잔여 승객 수 : " + this.maxPeople);
        System.out.println("상태 : " + this.state);
        System.out.println("속도 : " + this.speed);
        System.out.println("주유량 : " + this.gas);

        while(choose != 0) {
            System.out.println("\n1. 버스 정보 보기\n2. 버스 상태 변경\n3. 승객 탑승\n4. 속도 변경\n5. 주유하기\n0. 종료");
            i = scan.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\n버스 정보");
                    System.out.println("\n승객수 : " + this.inPeople);
                    System.out.println("잔여 승객 수 : " + this.maxPeople);
                    System.out.println("상태 : " + this.state);
                    System.out.println("속도 : " + this.speed);
                    System.out.println("주유량 : " + this.gas + "\n");
                    break;
                case 2:
                    System.out.print("상태 변경 : ");
                    str = scan.next();
                    bus2(str);
                    break;
                case 3:
                    if(this.state.equals("운행")||this.state.equals("운행중")) {
                        System.out.print("승객 탑승 : ");
                        i = scan.nextInt();
                        bus3(i);
                    }else {
                        System.out.println("운행중이 아닙니다.");
                    }
                    break;
                case 4:
                    System.out.print("속도 변경 : ");
                    i = scan.nextInt();
                    bus4(i);
                    break;
                case 5:
                    System.out.print("주유량 = ");
                    i = scan.nextInt();
                    bus5(i);
                    break;
                case 0:
                    choose = 0;
                    break;
                default:
                    System.out.println("0부터 5까지의 수만 입력해 주세요.");
                    break;
            }
        }
    }
}
