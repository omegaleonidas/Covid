package com.sidiq.covid19.model;

import com.google.gson.annotations.SerializedName;

public class ResultsItem{

    @SerializedName("kabupaten_kota")
    private String kabupatenKota;

    @SerializedName("covid_meninggal")
    private String covidMeninggal;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("odp_dalam_pemantauan")
    private String odpDalamPemantauan;

    @SerializedName("pdp_masih_dirawat")
    private String pdpMasihDirawat;

    @SerializedName("covid_dirawat")
    private String covidDirawat;

    @SerializedName("covid_isolasi_dirumah")
    private String covidIsolasiDirumah;

    @SerializedName("odp_selesai")
    private String odpSelesai;

    @SerializedName("tgl_update")
    private String tglUpdate;

    @SerializedName("pdp_suspec")
    private String pdpSuspec;

    @SerializedName("positif")
    private String positif;

    @SerializedName("kode_kota")
    private String kodeKota;

    @SerializedName("covid_sembuh")
    private String covidSembuh;

    @SerializedName("id")
    private String id;

    @SerializedName("total_odp")
    private String totalOdp;

    @SerializedName("pdp")
    private String pdp;

    @SerializedName("pdp_pulangdan_sehat")
    private String pdpPulangdanSehat;

    @SerializedName("longitude")
    private String longitude;

    public void setKabupatenKota(String kabupatenKota){
        this.kabupatenKota = kabupatenKota;
    }

    public String getKabupatenKota(){
        return kabupatenKota;
    }

    public void setCovidMeninggal(String covidMeninggal){
        this.covidMeninggal = covidMeninggal;
    }

    public String getCovidMeninggal(){
        return covidMeninggal;
    }

    public void setLatitude(String latitude){
        this.latitude = latitude;
    }

    public String getLatitude(){
        return latitude;
    }

    public void setOdpDalamPemantauan(String odpDalamPemantauan){
        this.odpDalamPemantauan = odpDalamPemantauan;
    }

    public String getOdpDalamPemantauan(){
        return odpDalamPemantauan;
    }

    public void setPdpMasihDirawat(String pdpMasihDirawat){
        this.pdpMasihDirawat = pdpMasihDirawat;
    }

    public String getPdpMasihDirawat(){
        return pdpMasihDirawat;
    }

    public void setCovidDirawat(String covidDirawat){
        this.covidDirawat = covidDirawat;
    }

    public String getCovidDirawat(){
        return covidDirawat;
    }

    public void setCovidIsolasiDirumah(String covidIsolasiDirumah){
        this.covidIsolasiDirumah = covidIsolasiDirumah;
    }

    public String getCovidIsolasiDirumah(){
        return covidIsolasiDirumah;
    }

    public void setOdpSelesai(String odpSelesai){
        this.odpSelesai = odpSelesai;
    }

    public String getOdpSelesai(){
        return odpSelesai;
    }

    public void setTglUpdate(String tglUpdate){
        this.tglUpdate = tglUpdate;
    }

    public String getTglUpdate(){
        return tglUpdate;
    }

    public void setPdpSuspec(String pdpSuspec){
        this.pdpSuspec = pdpSuspec;
    }

    public String getPdpSuspec(){
        return pdpSuspec;
    }

    public void setPositif(String positif){
        this.positif = positif;
    }

    public String getPositif(){
        return positif;
    }

    public void setKodeKota(String kodeKota){
        this.kodeKota = kodeKota;
    }

    public String getKodeKota(){
        return kodeKota;
    }

    public void setCovidSembuh(String covidSembuh){
        this.covidSembuh = covidSembuh;
    }

    public String getCovidSembuh(){
        return covidSembuh;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setTotalOdp(String totalOdp){
        this.totalOdp = totalOdp;
    }

    public String getTotalOdp(){
        return totalOdp;
    }

    public void setPdp(String pdp){
        this.pdp = pdp;
    }

    public String getPdp(){
        return pdp;
    }

    public void setPdpPulangdanSehat(String pdpPulangdanSehat){
        this.pdpPulangdanSehat = pdpPulangdanSehat;
    }

    public String getPdpPulangdanSehat(){
        return pdpPulangdanSehat;
    }

    public void setLongitude(String longitude){
        this.longitude = longitude;
    }

    public String getLongitude(){
        return longitude;
    }
}