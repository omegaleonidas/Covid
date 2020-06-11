package com.sidiq.covid19.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results{

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("kode_kota")
    @Expose
    public String kodeKota;
    @SerializedName("kabupaten_kota")
    @Expose
    public String kabupatenKota;
    @SerializedName("total_odp")
    @Expose
    public String totalOdp;
    @SerializedName("odp_dalam_pemantauan")
    @Expose
    public String odpDalamPemantauan;
    @SerializedName("odp_selesai")
    @Expose
    public String odpSelesai;
    @SerializedName("pdp")
    @Expose
    public String pdp;
    @SerializedName("pdp_masih_dirawat")
    @Expose
    public String pdpMasihDirawat;
    @SerializedName("pdp_pulangdan_sehat")
    @Expose
    public String pdpPulangdanSehat;
    @SerializedName("pdp_suspec")
    @Expose
    public String pdpSuspec;
    @SerializedName("positif")
    @Expose
    public String positif;
    @SerializedName("covid_dirawat")
    @Expose
    public String covidDirawat;
    @SerializedName("covid_sembuh")
    @Expose
    public String covidSembuh;
    @SerializedName("covid_meninggal")
    @Expose
    public String covidMeninggal;
    @SerializedName("covid_isolasi_dirumah")
    @Expose
    public String covidIsolasiDirumah;
    @SerializedName("latitude")
    @Expose
    public String latitude;
    @SerializedName("longitude")
    @Expose
    public String longitude;
    @SerializedName("tgl_update")
    @Expose
    public String tglUpdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKodeKota() {
        return kodeKota;
    }

    public void setKodeKota(String kodeKota) {
        this.kodeKota = kodeKota;
    }

    public String getKabupatenKota() {
        return kabupatenKota;
    }

    public void setKabupatenKota(String kabupatenKota) {
        this.kabupatenKota = kabupatenKota;
    }

    public String getTotalOdp() {
        return totalOdp;
    }

    public void setTotalOdp(String totalOdp) {
        this.totalOdp = totalOdp;
    }

    public String getOdpDalamPemantauan() {
        return odpDalamPemantauan;
    }

    public void setOdpDalamPemantauan(String odpDalamPemantauan) {
        this.odpDalamPemantauan = odpDalamPemantauan;
    }

    public String getOdpSelesai() {
        return odpSelesai;
    }

    public void setOdpSelesai(String odpSelesai) {
        this.odpSelesai = odpSelesai;
    }

    public String getPdp() {
        return pdp;
    }

    public void setPdp(String pdp) {
        this.pdp = pdp;
    }

    public String getPdpMasihDirawat() {
        return pdpMasihDirawat;
    }

    public void setPdpMasihDirawat(String pdpMasihDirawat) {
        this.pdpMasihDirawat = pdpMasihDirawat;
    }

    public String getPdpPulangdanSehat() {
        return pdpPulangdanSehat;
    }

    public void setPdpPulangdanSehat(String pdpPulangdanSehat) {
        this.pdpPulangdanSehat = pdpPulangdanSehat;
    }

    public String getPdpSuspec() {
        return pdpSuspec;
    }

    public void setPdpSuspec(String pdpSuspec) {
        this.pdpSuspec = pdpSuspec;
    }

    public String getPositif() {
        return positif;
    }

    public void setPositif(String positif) {
        this.positif = positif;
    }

    public String getCovidDirawat() {
        return covidDirawat;
    }

    public void setCovidDirawat(String covidDirawat) {
        this.covidDirawat = covidDirawat;
    }

    public String getCovidSembuh() {
        return covidSembuh;
    }

    public void setCovidSembuh(String covidSembuh) {
        this.covidSembuh = covidSembuh;
    }

    public String getCovidMeninggal() {
        return covidMeninggal;
    }

    public void setCovidMeninggal(String covidMeninggal) {
        this.covidMeninggal = covidMeninggal;
    }

    public String getCovidIsolasiDirumah() {
        return covidIsolasiDirumah;
    }

    public void setCovidIsolasiDirumah(String covidIsolasiDirumah) {
        this.covidIsolasiDirumah = covidIsolasiDirumah;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTglUpdate() {
        return tglUpdate;
    }

    public void setTglUpdate(String tglUpdate) {
        this.tglUpdate = tglUpdate;
    }
}