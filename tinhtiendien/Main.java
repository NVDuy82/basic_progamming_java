package tinhtiendien;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class DienSinhHoat {
  private String maHoGiaDinh;
  private int thang, nam;
  private int soDau, soCuoi, soDien;
  private int thanhTien;

  public DienSinhHoat() {
  }

  public DienSinhHoat(String maHoGiaDinh, int thang, int nam, int soDau, int soCuoi, int soDien) {
    this.maHoGiaDinh = maHoGiaDinh;
    this.thang = thang;
    this.nam = nam;
    this.soDau = soDau;
    this.soCuoi = soCuoi;
    this.soDien = soDien;
  }

  void input() {
    Scanner input = new Scanner(System.in);
    System.out.print("Nhap ma ho gia dinh: ");
    maHoGiaDinh = input.next();
    System.out.print("Nhap thang: ");
    thang = input.nextInt();
    System.out.print("Nhap nam: ");
    nam = input.nextInt();
    System.out.print("Nhap so dien su dung dau ky: ");
    soDau = input.nextInt();
    System.out.print("Nhap so dien su dung cuoi ky: ");
    soCuoi = input.nextInt();
  }
  
  void output() {
    System.out.printf("%s%s\n", "Ma ho GD   : ", maHoGiaDinh);
    System.out.printf("%s%d\n", "Thang      : ", thang);
    System.out.printf("%s%d\n", "Nam        : ", nam);
    System.out.printf("%s%d\n", "So Dien    : ", soDien);
    System.out.printf("%s%d\n", "Thanh Tien : ", thanhTien);
  }
  
  void tinh_so_dien() {
    soDien = soCuoi - soDau;
  }
  
  void tinh_thanh_tien() {
    GiaDien giaDien = new GiaDien(soDien);
    thanhTien = giaDien.tinhThanhTien();
  }

  public String getMaHoGiaDinh() {
    return maHoGiaDinh;
  }

  public void setMaHoGiaDinh(String maHoGiaDinh) {
    this.maHoGiaDinh = maHoGiaDinh;
  }

  public int getThang() {
    return thang;
  }

  public void setThang(int thang) {
    this.thang = thang;
  }

  public int getNam() {
    return nam;
  }

  public void setNam(int nam) {
    this.nam = nam;
  }

  public int getSoDau() {
    return soDau;
  }

  public void setSoDau(int soDau) {
    this.soDau = soDau;
  }

  public int getSoCuoi() {
    return soCuoi;
  }

  public void setSoCuoi(int soCuoi) {
    this.soCuoi = soCuoi;
  }

  public int getSoDien() {
    return soDien;
  }

  public void setSoDien(int soDien) {
    this.soDien = soDien;
  }

  public int getThanhTien() {
    return thanhTien;
  }

  public void setThanhTien(int thanhTien) {
    this.thanhTien = thanhTien;
  }
}

class Bac {
  private final int lowerLimit;
  private final int donGia;
  
  public Bac(int lowerLimit, int donGia) {
    this.lowerLimit = lowerLimit;
    this.donGia = donGia;
  }
  
  public int getLowerLimit() {
    return lowerLimit;
  }
  
  public int getDonGia() {
    return donGia;
  }
}

class GiaDien {
  private final Bac bac1 = new Bac(1, 1678);
  private final Bac bac2 = new Bac(51, 1734);
  private final Bac bac3 = new Bac(101, 2014);
  private final Bac bac4 = new Bac(201, 2536);
  private final Bac bac5 = new Bac(301, 2834);
  private final Bac bac6 = new Bac(401, 2927);
  private List<Bac> rule = new ArrayList<>();
  
  private int soDien;
  
  public GiaDien(int soDien) {
    this.soDien = soDien;
    rule.add(bac1);
    rule.add(bac2);
    rule.add(bac3);
    rule.add(bac4);
    rule.add(bac5);
    rule.add(bac6);
  }
  
  int tinhThanhTien() {
    int res = 0;
    for (int i = rule.size() - 1; i >= 0 ; i--) {
      if (soDien >= rule.get(i).getLowerLimit()) {
        res += (soDien - rule.get(i).getLowerLimit() + 1) * rule.get(i).getDonGia();
      }
    }
    return res;
  }
}

public class Main {
  public static void main(String[] args) {
    DienSinhHoat dienSinhHoat = new DienSinhHoat();
    dienSinhHoat.input();
    dienSinhHoat.tinh_so_dien();
    dienSinhHoat.tinh_thanh_tien();
    System.out.println("=================================");
    dienSinhHoat.output();
  }
}
