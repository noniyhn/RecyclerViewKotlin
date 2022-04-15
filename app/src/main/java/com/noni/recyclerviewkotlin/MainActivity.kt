package com.noni.recyclerviewkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.mr,
                "marvel",
                "Siapa yang tidak kenal dengan film Marvel Universe?\n" +
                        "\n" +
                        "Film-film mereka sangat populer mulai dari Spiderman, Iron Man, " +
                        "Captain America sampai Black Widow.\n" +
                        "\n" +
                        "Sejak debut Iron Man pada tahun 2008, " +
                        "Marvel Cinematic Universe telah menghadirkan " +
                        "film-film superhero terbaik dengan beberapa " +
                        "karakter buku komik terhebat sepanjang masa."
            ),
            Superhero(
                R.drawable.sm,
                "Super Man",
                "Diciptakan oleh seorang seniman Kanada, " +
                        "Joe Shuster, dan penulis Amerika Serikat Jerry Siegel pada tahun 1932 " +
                        "saat mereka masih remaja di Cleveland, " +
                        "Ohio dan kemudian menjualnya kepada Detective Comics, Inc. " +
                        "pada 1938. Superman pertama kali muncul " +
                        "dalam serial Action Comics (\"Komik Aksi\") edisi #1 " +
                        "di Amerika Serikat (30 Juni 1938) dan kemudian juga muncul" +
                        " di berbagai serial drama radio, acara televisi, " +
                        "film layar lebar, surat kabar, komik, novel, " +
                        "dan permainan video berbahasa Inggris. "
            ),
            Superhero(
                R.drawable.ir,
                "Iron Man",
                "Iron Man adalah pahlawan super fiksi yang " +
                        "muncul dalam buku komik Amerika yang diterbitkan " +
                        "oleh Marvel Comics, serta media yang terkait. " +
                        "Karakter diciptakan oleh penulis dan editor Stan Lee," +
                        " yang dikembangkan oleh penulis skenario Larry Lieber, " +
                        "dan dirancang oleh seniman Don Heck dan Jack Kirby."
            ),

            Superhero(
                R.drawable.l,
                "Spider Man",
                "Serial Spider-Man menceritakan Peter Parker," +
                        " siswa SMA di balik identitas Spider-Man, " +
                        "seorang remaja yang di gambarkan masih labil dan penuh obsesi," +
                        " korban bully dan di selimuti kesepian karena dalam kisah origin nya, " +
                        "Peter Parker adalah seorang yatim piatu."
            ),
            Superhero(
                R.drawable.t,
                "Thor",
                " Ini adalah film keempat di Marvel Cinematic Universe. " +
                        "Film ini disutradarai oleh Kenneth Branagh," +
                        " yang ditulis oleh Ashley Edward Miller & Zack Stentz dan Don Payne, " +
                        "dan membintangi Chris Hemsworth, Natalie Portman, Tom Hiddleston," +
                        " Stellan Skarsgård, Colm Feore, Ray Stevenson, Idris Elba, Kat Dennings, " +
                        "Rene Russo dan Anthony Hopkins. Film tersebut melihat Thor," +
                        " putra mahkota Asgard, dibuang ke Bumi dan melepaskan kekuasaannya" +
                        " setelah dia menyalakan kembali sebuah perang yang tidak aktif"
            ),
            Superhero(
                R.drawable.b,
                "Bat Man",
                "Identitas rahasia Batman adalah Bruce Wayne, " +
                        "playboy Amerika yang kaya, dermawan, dan pemilik Wayne Enterprises." +
                        " Setelah menyaksikan pembunuhan orang tuanya, " +
                        "Dr. Thomas Wayne dan Martha Wayne ketika masih anak-anak," +
                        " ia bersumpah membalas dendam terhadap para penjahat, " +
                        "sebuah sumpah yang digerakkan oleh rasa keadilan. " +
                        "Bruce Wayne melatih dirinya sendiri secara fisik dan intelektual" +
                        " dan menciptakan kepribadian yang terinspirasi kelelawar untuk memerangi kejahatan."
            )
        )

        val recyclerView=findViewById<RecyclerView>(R.id.nn_hero)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this, superheroList){
            val intent = Intent(this, DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}