import java.util.Scanner;

public class Taxi extends Main{
    Scanner scan = new Scanner(System.in);
    int number;
    int gas;
    int speed;
    String destination;
    int road = 1;
    int desRoad;
    int cost = 3000;
    int desCost = 1000;
    String state = "일반";
    int maxPeople = 4;
    int inPeople = 0;
    int peopleCost = 0;
    int totalCost = 0;

    int j=0;


    Taxi(int gas, int speed){
        this.gas = gas;
        this.speed = speed;
    }

    public void taxi2(int inPeople, String destination, int desRoad){
        if(desRoad>1){
            peopleCost = 3000 + (desRoad-1)*1000;
        }else peopleCost = 3000;

        this.state = "운행중";
        this.totalCost += peopleCost;
        System.out.println("\n탑승 승객 수 : " + inPeople + "\n잔여 승객 수 : " + (this.maxPeople-inPeople) + "\n기본 요금 확인 : " + this.cost + "\n목적지 : " + destination );
        System.out.println("목적지까지 거리 : " + desRoad + "\n지불할 요금 : " + peopleCost + "\n상태 : " + this.state);
        taxi3();
    }

    public void taxi3(){
        this.state = "일반";
        System.out.print("\n주유량 : ");
        j = scan.nextInt();
        if(this.gas + j <0){
            System.out.println("기름이 0보다 적습니다.");
            taxi3();
        }else if (this.gas + j < 10){
            this.gas += j;
            System.out.println("\n요금 결제\n\n주유량 : " + this.gas + "\n상태 : " + "운행불가\n누적 요금 : " + this.totalCost + "\n\n주유 필요");
        }else {
            this.gas += j;
            System.out.println("\n요금 결제\n\n주유량 : " + this.gas + "\n누적 요금 : " + this.totalCost);
        }
    }

    public void taxiSpeed(int speed){
        this.speed += speed;
        System.out.println("\n속도 : " + this.speed);
    }

    public void taxi5(String str){

    }

    public void taxi() {
        int choose = 1;
        int i;
        String str;
        System.out.println("\n택시 정보");
        System.out.println("\n승객수 : " + this.inPeople);
        System.out.println("상태 : " + this.state);
        System.out.println("속도 : " + this.speed);
        System.out.println("주유량 : " + this.gas);
        System.out.println("누적 요금 : " + this.totalCost);

        while(choose != 0) {
            System.out.println("\n1. 택시 정보 보기\n2. 손님 탑승\n3. 속도 변경\n0. 종료");
            i = scan.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\n택시 정보");
                    System.out.println("\n승객수 : " + this.inPeople);
                    System.out.println("상태 : " + this.state);
                    System.out.println("속도 : " + this.speed);
                    System.out.println("주유량 : " + this.gas);
                    System.out.println("누적 요금 : " + this.totalCost);
                    break;
                case 2:
                    System.out.print("승객 목적지 거리를 입력해 주세요\n승객 : ");
                    i = scan.nextInt();
                    if(i>this.maxPeople){
                        System.out.println("\n최대 승객 수 초과");
                    }else {
                        System.out.print("목적지 : ");
                        str = scan.next();
                        System.out.print("목적지까지 거리 = ");
                        int j = scan.nextInt();
                        taxi2(i, str, j);
                    }
                    break;
                case 3:
                    System.out.println("속도 입력");
                    i = scan.nextInt();
                    taxiSpeed(i);
                    break;
                case 0:
                    choose = 0;
                    break;
                default:
                    System.out.println("0부터 3까지의 수만 입력해 주세요.");
                    break;
            }
        }
    }
}
