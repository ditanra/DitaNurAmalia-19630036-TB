-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Jan 2022 pada 04.13
-- Versi server: 10.3.16-MariaDB
-- Versi PHP: 7.1.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `objekwisata`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `absensi`
--

CREATE TABLE `absensi` (
  `tgl` date NOT NULL,
  `nama_petugas` varchar(20) NOT NULL,
  `shift` varchar(10) NOT NULL,
  `jabatan` varchar(10) NOT NULL,
  `jam_masuk` varchar(10) NOT NULL,
  `jam_pulang` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `absensi`
--

INSERT INTO `absensi` (`tgl`, `nama_petugas`, `shift`, `jabatan`, `jam_masuk`, `jam_pulang`) VALUES
('2021-12-08', 'gf', '4', 'f', '355', '53');

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(30) NOT NULL,
  `password` varchar(40) NOT NULL,
  `nama` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`, `nama`) VALUES
('admin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pendaftaran`
--

CREATE TABLE `pendaftaran` (
  `Nama` varchar(20) NOT NULL,
  `Umur` int(5) NOT NULL,
  `Tanggal_lahir` date NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `Jenis_kelamin` varchar(10) NOT NULL,
  `Nama_Grup` varchar(20) NOT NULL,
  `Jam_submit` varchar(10) NOT NULL,
  `No_HP_Ortu` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pendaftaran`
--

INSERT INTO `pendaftaran` (`Nama`, `Umur`, `Tanggal_lahir`, `Alamat`, `Jenis_kelamin`, `Nama_Grup`, `Jam_submit`, `No_HP_Ortu`) VALUES
('agus', 123666666, '2022-01-03', 'dd', 'Laki-Laki', 'sd3', '3', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pulang`
--

CREATE TABLE `pulang` (
  `nama` varchar(20) NOT NULL,
  `nama_grup` varchar(20) NOT NULL,
  `umur` varchar(10) NOT NULL,
  `tgl` date NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jk` varchar(20) NOT NULL,
  `jam_pulang` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pulang`
--

INSERT INTO `pulang` (`nama`, `nama_grup`, `umur`, `tgl`, `alamat`, `jk`, `jam_pulang`) VALUES
('ayub', '12', '15', '2020-08-07', 'jl. arrty', 'laki', '12.20');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
