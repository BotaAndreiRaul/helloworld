import java.util.Scanner;

public class main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduceti cantitatea de materie prima");
            Depozit dep = new Depozit();
            dep.rest = new int[1000];
            int quantity = sc.nextInt();
            dep.setPrimeMaterial(quantity);
            System.out.println("Sunt " + dep.getPrimeMaterial() + " de bucati de materie prima");
            System.out.println("Introduceti codul (trebuie sa fie de maxim 3 cifre), de cate bucati este nevoie si in cate bucati trebuie taiata materia prima");
            int code = sc.nextInt();
            int pieces = sc.nextInt();
            int cutmaterial = sc.nextInt();
            Comanda com = new Comanda(code,pieces,cutmaterial);
            while(code!=0){
                   if(com.checkCode(code)>3) {
                           System.out.println("Cod invalid introduceti din nou");
                           code = sc.nextInt();
                           com.setCode(code);
                   }
                   else
                           break;
            }
            com.cuts = new int[1000];
            com.cuts[code] = cutmaterial;
            System.out.println(com);
            System.out.println("Trebuie taiate " +  com.materialNeeded(com.cuts[code]) + " de bucati");
            System.out.println("Introduceti in cate zile trebuie finalizata comanda si cate bucati se produc pe zi:");
            int days = sc.nextInt();
            int pieces_a_day = sc.nextInt();
            Timp time = new Timp(days,pieces_a_day);
            System.out.println(time);
            if(com.materialNeeded(com.cuts[code])>dep.getPrimeMaterial())
                    System.out.println("Nu este destula materie prima");
            else{
                    dep.rest[code] = com.remainingPieces();
                    if(time.checkTime(pieces)==false)
                            System.out.println("Aceasta comanda a avut intarzieri, clientul va fi nemultumit");
                    else
                            System.out.println("Comanda a fost realizata la timp");
                    if(dep.rest[code]>0)
                            System.out.println("Din codul " + code + " au mai ramas " + dep.rest[code] + " de bucati");
                    else
                            System.out.println("Nu a mai ramas material in plus");}
            int remainingMaterial = dep.getPrimeMaterial()-com.materialNeeded(cutmaterial);
            System.out.println("Au mai ramas " + remainingMaterial + " de bucati de materie prima");
            while(remainingMaterial>0){
                    System.out.println("Introduceti noua comanda (codul trebuie sa fie de maxim 3 cifre):");
                    code = sc.nextInt();
                    while(code!=0){
                            if(com.checkCode(code)>3) {
                                    System.out.println("Cod invalid introduceti din nou:");
                                    code = sc.nextInt();
                                    com.setCode(code);
                            }
                            else{
                                    System.out.println("Cod valid, continuati mai departe:");
                                    break;}
                    }
                    pieces = sc.nextInt();
                    if(com.cuts[code]>0)
                            System.out.println("Pentru codul " + code + " se taie " + com.cuts[code] + " de bucati din materia prima");
                    else {
                            System.out.println("Introduceti pentru codul " + code + " cate bucati trebuie taiate din materia prima");
                            com.cuts[code] = sc.nextInt();
                    }
                    if(dep.rest[code] > 0){
                            System.out.println("Pentru codul " + code + " sunt in depozit " + dep.rest[code] + " bucati");
                            pieces -= dep.rest[code];
                    }
                    com.setCode(code);
                    com.setPieces(pieces);
                    com.setCutmaterial(com.cuts[code]);
                    System.out.println(com);
                    System.out.println("Trebuie taiate " +  com.materialNeeded(com.cuts[code]) + " de bucati");
                    if(com.materialNeeded(com.cuts[code])>remainingMaterial) {
                            System.out.println("Nu este destula materie prima");
                            break;
                    }
                    System.out.println("Introduceti in cate zile trebuie finalizata comanda si cate bucati se produc pe zi:");
                    days = sc.nextInt();
                    pieces_a_day = sc.nextInt();
                    time.setDays(days);
                    time.setPieces_a_day(pieces_a_day);
                    System.out.println(time);
                    if(time.checkTime(pieces)==false)
                            System.out.println("Aceasta comanda a avut intarzieri, clientul va fi nemultumit");
                    else
                            System.out.println("Comanda a fost realizata la timp");
                    dep.rest[code] = com.remainingPieces();
                    if(dep.rest[code]>0)
                            System.out.println("Din codul " + code + " au mai ramas " + dep.rest[code] + " de bucati");
                    else
                            System.out.println("Nu a mai ramas material in plus");
                  remainingMaterial = remainingMaterial-com.materialNeeded(com.cuts[code]);
                  System.out.println("Au mai ramas " + remainingMaterial + " de bucati de materie prima");
            }
    }
}
