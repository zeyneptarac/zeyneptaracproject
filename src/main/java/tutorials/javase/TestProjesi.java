package tutorials.javase;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TestProjesi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int score = 0; // doğru cevapların sayısını tutacak değişken
        boolean[] alreadyAnswered = new boolean[10]; // kullanıcının bir soruya sadece bir kez cevap vermesini sağlamak için kullanılacak boolean array
        String[] questions = {
                "Soru 1: Java'nın yaratıcısı kimdir?",
                "Soru 2: Java hangi yıl piyasaya sürülmüştür?",
                "Soru 3: Java platformu hangi dili kullanarak yazılmıştır?",
                "Soru 4: Java'nın en önemli özelliklerinden biri nedir?",
                "Soru 5: Java uygulamaları hangi formatta derlenir?",
                "Soru 6: Java'nın sürüm numaralandırması nasıldır?",
                "Soru 7: Java uygulamalarının çalıştırılması için hangi program gerekir?",
                "Soru 8: Java'da sınıflar nasıl organize edilir?",
                "Soru 9: Java'da final anahtar kelimesi ne anlama gelir?",
                "Soru 10: Java'da kullanılan en popüler veri tabanı sistemi hangisidir?"
        };
        String[][] options = {
                {"a) James Gosling", "b) Linus Torvalds", "c) Bill Gates", "d) Steve Jobs", "e) Larry Page"},
                {"a) 1990", "b) 1991", "c) 1992", "d) 1993", "e) 1994"},
                {"a) C", "b) C++", "c) Smalltalk", "d) Ada", "e) Assembly"},
                {"a) Nesne yönelimli programlama", "b) Çoklu platform desteği", "c) Garbage collection", "d) Yüksek performans", "e) Veri tabanı desteği"},
                {"a) .exe", "b) .jar", "c) .dll", "d) .py", "e) .bat"},
                {"a) MAJOR.MINOR.PATCH", "b) VERSION.BUILD.REVISION", "c) X.Y.Z", "d) A.B.C.D", "e) 1.0.0.0"},
                {"a) Eclipse", "b) NetBeans", "c) IntelliJ IDEA", "d) Visual Studio", "e) Android Studio"},
                {"a) Dosya tarihine göre", "b) Dosya boyutuna göre", "c) Alfabetik sıraya göre", "d) Sınıf hiyerarşisine göre", "e) Özelleştirilebilir sıraya göre"},
                {"a) Değiştirilemez değer", "b) Fonksiyon", "c) Değiştirilebilir değer", "d) Global değişken", "e) Yerel değişken"},
                {"a) MySQL", "b) Oracle", "c) Microsoft SQL Server", "d) PostgreSQL", "e) MongoDB"}
        };
        String[] answers = {"a", "b", "a", "c", "b", "c", "a", "d", "a", "b"}; // doğru cevapların tutulduğu array
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int time = 2400; // 40 dakika test süresi

            public void run() {
                time--;
                if (time == 0) {
                    System.out.println("Süreniz doldu!");
                    System.out.println("Testi tamamlayamadınız.");
                    System.exit(0); // programdan çıkış
                }
            }
        };
        timer.schedule(task, 0, 1000); // 1 saniyede bir zamanı azaltmak için
        for (int i = 0; i < 10; i++) {
            System.out.println(questions[i]);
            for (int j = 0; j < 5; j++) {
                System.out.println(options[i][j]);
            }
            String userAnswer;
            do {
                System.out.print("Cevabınızı girin: ");
                userAnswer = input.nextLine();
            } while (!isValidAnswer(userAnswer)); // geçerli bir cevap girilene kadar kullanıcıdan girdi istenir
            if (userAnswer.equalsIgnoreCase(answers[i]) && !alreadyAnswered[i]) {
                score++;
                alreadyAnswered[i] = true;
            }
        }
        timer.cancel(); // zamanlayıcıyı iptal et
        System.out.println("Testi tamamladınız. Puanınız: " + score + "/10");
        System.exit(0); // programdan çıkış
    }
    public static boolean isValidAnswer(String answer) {
        if (answer.length() != 1) {
            return false;
        }
        char c = answer.charAt(0);
        return c >= 'a' && c <= 'e';
    }
}
