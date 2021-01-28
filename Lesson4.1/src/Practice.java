public class Practice {
    public static void main(String[] args) {

        primary_loop:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i + j > 5) {
                    System.out.println("ALARM");
                    break primary_loop;
                }
                System.out.println(i + " " + j);
            }
        }

        System.out.println("Done!");



        one:
        {
            System.out.println("start of one");
            two:
            {
                System.out.println("start of two");
                three:
                {
                    System.out.println("start of three");

                    System.out.println("end of three");
                }
                System.out.println("end of two");
            }
            System.out.println("end of one");
        }

    }


}
