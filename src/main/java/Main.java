import java.util.Scanner;

public class Main {
    int gas = 100;
    int speed = 0;

    public void menu() {
        int choose = 1;
        int choose1 = 1;
        int choose2 = 1;
        int i;
        int j;
        int k;
        while(choose!=0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("대중교통 프로그램\n1. 버스\n2. 택시\n0. 종료");
            i = scan.nextInt();
            System.out.println(i);

            switch (i) {
                case 1:
                    choose1 = 1;
                    Bus bus1 = new Bus(gas, speed);
                    Bus bus2 = new Bus(gas, speed);
                    while (choose1 !=0) {
                        System.out.println("버스를 2대 생성하였습니다. 어떤 버스를 선택하시겠습니까?\n\n1. 1번 버스\n2. 2번 버스\n0. 종료");
                        i = scan.nextInt();
                        switch (i) {
                            case 1:
                                bus1.bus();
                                break;
                            case 2:
                                bus2.bus();
                                break;
                            case 0:
                                choose1 = 0;
                                break;
                            default:
                                System.out.println("0부터 2까지의 정수만 입력해 주세요.");
                                break;
                        }
                    }
                    break;
                case 2:
                    choose2 = 1;
                    Taxi taxi1 = new Taxi(gas, speed);
                    Taxi taxi2 = new Taxi(gas, speed);
                    while (choose2 !=0) {
                        System.out.println("택시를 2대 생성하였습니다. 어떤 택시를 선택하시겠습니까?\n\n1. 1번 택시\n2. 2번 택시\n0. 종료");
                        i = scan.nextInt();
                        switch (i) {
                            case 1:
                                taxi1.taxi();
                                break;
                            case 2:
                                taxi2.taxi();
                                break;
                            case 0:
                                choose2 = 0;
                                break;
                            default:
                                System.out.println("0부터 2까지의 정수만 입력해 주세요.");
                                break;
                        }
                    }
                    break;
                case 0:
                    choose = 0;
                    break;
                default:
                    System.out.println("0부터 2까지의 정수만 입력해 주세요.");
                    break;
            }
        }
    }


    public static void main(String[] args) {
        Main method = new Main();
        method.menu();
    }
}
