package com.example.marisaagustina;
import android.content.Context;
import com.example.marisaagustina.menu.Makanan;
import com.example.marisaagustina.menu.Ayam;
import com.example.marisaagustina.menu.Ikan;
import com.example.marisaagustina.menu.Sapi;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static List<Makanan> makanans = new ArrayList<>();

    private static List<Ayam> inimakananayam(Context ctx) {
        List<Ayam> ayams = new ArrayList<>();
        ayams.add(new Ayam("Ayam Tangkep", "Aceh",
                "AcehAyam Tangkap adalah masakan khas Aceh, yang terbuat dari ayam yang digoreng dengan bumbu dan rempah-rempah khas. Saat disajikan Ayam ini tampak unik, karena banyak Daun pandan yang ikut tergoreng dan disajikan di piring.", R.drawable.ayamaceh));
        ayams.add(new Ayam("Ayam Butut", "Bali",
                "Makanan khas Ayam Bututu ini adalah salah satu yang paling enggak boleh dilewatkan saat liburan ke Bali, apalagi buat kamu yang suka makanan pedas.", R.drawable.ayambali));
        ayams.add(new Ayam("Ayam Bumbu Rujak", "Jawa",
                "Ayam Bumbu Rujak adalah sebuah makanan Jawa khas yang terbuat dari daging ayam yang masih muda dan dibumbui bumbu merah yang digiling.", R.drawable.ayamjawa));
        return ayams;
    }


    private static List<Sapi> inimakanansapi(Context ctx) {
        List<Sapi> sapis = new ArrayList<>();
        sapis.add(new Sapi("Dendeng Aceh Rayeuk", "Aceh",
                "Dendeng Daging Sapi adalah salah satu makanan khas Aceh. Dibuat Dari Daging Sapi pilihan yang bermutu tinggi dan hygienis lalu diolah dengan tambahan rempah dan bumbu tradisional..", R.drawable.sapiaceh));
        sapis.add(new Sapi("Serapah", "Bali",
                "Serapah daging adalah masakan khas Bali berupa daging sapi yang direbus menggunakan santan. Sangat kaya bumbu dan bikin ketagihan.", R.drawable.sapibali));
        sapis.add(new Sapi("Lapis Daging", "Jawa",
                "Lapis daging merupakan salah satu jenis makanan yang cukup populer di Jawa Timur. Seperti namanya lapis daging, maka sudah jelas jenis makanan ini memiliki tekstur daging yang berlapis-lapis.", R.drawable.sapijawa));
        return sapis;
    }

    private static List<Ikan> inimakananikan(Context ctx) {
        List<Ikan> ikans = new ArrayList<>();
        ikans.add(new Ikan("Ikan Eungkot", "Aceh",
                "Salah satunya adalah masakan khas Aceh berbahan dasar ikan laut. Namanya eungkot keumamah atau lebih dikenal dengan keumamah. Bahan dasarnya adalah ikan tongkol atau cakalang.", R.drawable.ikanaceh));
        ikans.add(new Ikan("Ikan Laut Sambal Mentah", "Bali",
                "Makanan khas Bali di Jimbaran tersebut adalah bahasa Balinya ikan laut sambal mentah,Dengan potensi hasil ikan yang besar dan masyarakatnya yang dominan menjadi nelayan, Bali punya olahan dari ikan dengan nama be pasih mesambel matah.", R.drawable.ikanbali));
        ikans.add(new Ikan("Pathak Ikan Jahan", "Jawa",
                "Makanan tradisional yang menjadi kekayaan kuliner sebuah kabupaten di pesisir Pulau Jawa ini tampak seperti rica-rica karena mengandung kuah kental berwarna kuning kemerahan.", R.drawable.ikanjawa));
        return ikans;
    }
    private static void initAllMakanans(Context ctx) {
        makanans.addAll(inimakananayam(ctx));
        makanans.addAll(inimakanansapi(ctx));
        makanans.addAll(inimakananikan(ctx));
    }

    public static List<Makanan> getAllMakanan(Context ctx, String genreFilm) {
        if (makanans.size() == 0) {
            initAllMakanans(ctx);
        }
        return  makanans;
    }

    public static List<Makanan> getMakanansByTipe(Context ctx, String jenis) {
        List<Makanan> makanansByType = new ArrayList<>();
        if (makanans.size() == 0) {
            initAllMakanans(ctx);
        }
        for (Makanan m : makanans) {
            if (m.getJenis().equals(jenis)) {
                makanansByType.add(m);
            }
        }
        return makanansByType;
    }

}
