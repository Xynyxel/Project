# Unit Testing

MovieViewModelTest
- Memanipulasi data ketika pemanggilan data movie di kelas CatalogueRepository.
- Memastikan metode di kelas CatalogueRepository terpanggil.
- Memastikan fungsi dari getMovie bisa di panggil

TvShowViewModelTest
- Memanipulasi data ketika pemanggilan data tvshow di kelas CatalogueRepository.
- Memastikan metode di kelas CatalogueRepository terpanggil.
- Memastikan fungsi dari getTvshow bisa di panggil

DetaiViewModel
- Memanipulasi data ketika pemanggilan data detail movie di kelas CatalogueRepository.
- Memanipulasi data ketika pemanggilan data detail tvshow di kelas CatalogueRepository.
- Memastikan metode di kelas CatalogueRepository terpanggil.
- Memastikan fungsi getDetailMovie bisa di panggil
- Memastikan fungsi getDetailTvShow bisa di panggil
- Memastikan fungsi setFavoriteTvShow bisa di panggil
- Memastikan fungsi setFavoriteMovie bisa di panggil

FavoriteViewModel
- Memanipulasi data ketika pemanggilan data favorite movie di kelas CatalogueRepository.
- Memanipulasi data ketika pemanggilan data favorite tvshow di kelas CatalogueRepository.
- Memastikan metode di kelas CatalogueRepository terpanggil.
- Memastikan fungsi getFavoriteTvShow bisa di panggil
- Memastikan fungsi getFavoriteMovie bisa di panggil

# Instrumental Testing

Menampilkan data movie
- Klik TabLayout dengan teks movie
- Memastikan rv_Movie dalam keadaan tampil.
- Gulir rv_Movie ke posisi data terakhir.

Menampilkan data tvShow
- Klik TabLayout dengan teks tvShow
- Memastikan rv_TvShow dalam keadaan tampil.
- Gulir rv_TvShow ke posisi data terakhir.

Menampilkan data detail movie
- Memberi tindakan klik pada data pertama di rv_Movie.
- Memastikan Detail Movie bisa di buka
- Memastikan Button Favorite bisa di klik
- Melakukan klik favorite

Menampilkan data detail tvShow
- Memberi tindakan klik pada data pertama di rv_Tvshow.
- Memastikan Detail TvShow bisa di buka
- Memastikan Button Favorite bisa di klik
- Melakukan klik favorite

Menampilkan data pada Favorite Movie
- Memberikan tindakan klik pada button favorite untuk menuju halaman favorite
- Klik TabLayout dengan teks movie
- Memastikan data dari rv_movie muncul
- Mencoba melakukan klik pada item favotite movie pertama

Menampilkan data pada Favorite TvShow
- Memberikan tindakan klik pada button favorite untuk menuju halaman favorite
- Klik TabLayout dengan teks tvshow
- Memastikan data dari rv_tvshow muncul
- Mencoba melakukan klik pada item favotite tvshow pertama
