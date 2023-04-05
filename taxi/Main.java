package taxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Date {
  int dd, mm, yy;
  
  public Date() {
  }
  
  public Date(int dd, int mm, int yy) {
    this.dd = dd;
    this.mm = mm;
    this.yy = yy;
  }
  
  public void input() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("• Ngay: ");
    dd = scanner.nextInt();
    System.out.print("• Thang: ");
    mm = scanner.nextInt();
    System.out.print("• Nam: ");
    yy = scanner.nextInt();
  }
  
  @Override
  public String toString() {
    return dd + "-" + mm + "-" + yy;
  }
}

class TaxiGSM {
  private String maXe;
  private String hoTen;
  private Date ngayDi;
  private String noiXuatPhat;
  private String noiDen;
  private double soKm;
  private double thanhTien;
  
  public TaxiGSM() {
    ngayDi = new Date();
  }
  
  public TaxiGSM(String maXe, String hoTen, Date ngayDi, String noiXuatPhat, String noiDen, double soKm) {
    this.maXe = maXe;
    this.hoTen = hoTen;
    this.ngayDi = ngayDi;
    this.noiXuatPhat = noiXuatPhat;
    this.noiDen = noiDen;
    this.soKm = soKm;
  }
  
  public void input() {
    Scanner input = new Scanner(System.in);
    System.out.print("Nhap ma xe: ");
    maXe = input.nextLine();
    System.out.print("Nhap ho ten khach hang: ");
    hoTen = input.nextLine();
    System.out.println("Nhap ngay di (dd-mm-yyyy):");
    ngayDi.input();
    System.out.print("Nhap noi xuat phat: ");
    noiXuatPhat = input.nextLine();
    System.out.print("Nhap noi den: ");
    noiDen = input.nextLine();
    System.out.print("Nhap so km da di: ");
    soKm = input.nextDouble();
  }
  
  public void output() {
    Scanner input = new Scanner(System.in);
    System.out.print("Ma xe                : ");
    System.out.println(maXe);
    System.out.print("Ho ten khach hang    : ");
    System.out.println(hoTen);
    System.out.print("Ngay di (dd-mm-yyyy) : ");
    System.out.println(ngayDi);
    System.out.print("Noi xuat phat        : ");
    System.out.println(noiXuatPhat);
    System.out.print("Noi den              : ");
    System.out.println(noiDen);
    System.out.print("So km da di          : ");
    System.out.println(soKm);
    System.out.print("Thanh tien           : ");
    System.out.println(thanhTien);
  }
  
  public void tinhThanhTien() {
    GiaTaxiGSM giaTaxiGSM = new GiaTaxiGSM(soKm);
    thanhTien = giaTaxiGSM.tinhThanhTien();
  }
  
  public String getMaXe() {
    return maXe;
  }
  
  public String getHoTen() {
    return hoTen;
  }
  
  public Date getNgayDi() {
    return ngayDi;
  }
  
  public String getNoiXuatPhat() {
    return noiXuatPhat;
  }
  
  public String getNoiDen() {
    return noiDen;
  }
  
  public double getSoKm() {
    return soKm;
  }
  
  public double getThanhTien() {
    return thanhTien;
  }
}

class MucGia {
  private final int lowerLimit;
  private final int donGia;
  
  public MucGia(int lowerLimit, int donGia) {
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

class GiaTaxiGSM {
  private final MucGia muc1 = new MucGia(1, 20000);
  private final MucGia muc2 = new MucGia(2, 15500);
  private final MucGia muc3 = new MucGia(26, 12500);
  private List<MucGia> rule = new ArrayList<>();
  double soKm;
  
  public GiaTaxiGSM(double soKm) {
    this.soKm = soKm;
    rule.add(muc1);
    rule.add(muc2);
    rule.add(muc3);
  }
  
  double tinhThanhTien() {
    double res = 0;
    for (int i = rule.size() - 1; i >= 0 ; i--) {
      if (soKm >= rule.get(i).getLowerLimit()) {
        res += (soKm - rule.get(i).getLowerLimit() + 1) * rule.get(i).getDonGia();
      }
    }
    return res;
  }
}

public class Main {
  public static void main(String[] args) {
    TaxiGSM taxiGSM = new TaxiGSM();
    taxiGSM.input();
    taxiGSM.tinhThanhTien();
    System.out.println("============================================");
    taxiGSM.output();
  }
}
