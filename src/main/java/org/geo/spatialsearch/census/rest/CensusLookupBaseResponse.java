package org.geo.spatialsearch.census.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.geo.spatialsearch.census.model.State2010;

/**
 * 
 * @author Juan Marin
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CensusLookupBaseResponse {

    @XmlElement(name = "state")
    private List<State2010> states;

    // @XmlElement(name = "county")
    // private List<County2000> counties;
    //
    // @XmlElement(name = "censusTract")
    // private List<Tract2000> tracts;
    //
    // @XmlElement(name = "block")
    // private List<Block2000> blocks;
    //
    // @XmlElement(name = "censusPlace")
    // private List<Place> places;
    //
    // @XmlElement(name = "stateSenateDistrict")
    // private List<StateSenateDistrict> stateSenateDistricts;
    //
    // @XmlElement(name = "stateHouseDistrict")
    // private List<StateHouseDistrict> stateHouseDistricts;
    //
    // @XmlElement(name = "msa")
    // private List<MSA> msas;
    //
    // @XmlElement(name = "congressionalDistrict")
    // private List<CongDistrict> congDistricts;
    //
    // @XmlElement(name = "tribalNations")
    // private List<Tribal> tribalNations;
    //
    // @XmlElement(name = "USF")
    // private List<Usf> usfList;
    //
    public CensusLookupBaseResponse() {
    }

    public List<State2010> getStates() {
        if (states == null) {
            states = new ArrayList<State2010>();
        }
        return states;
    }

    public void setStates(List<State2010> states) {
        this.states = states;
    }

    // public List<County2000> getCounties() {
    // if (counties == null) {
    // counties = new ArrayList<County2000>();
    // }
    // return counties;
    // }
    //
    // public void setCounties(List<County2000> counties) {
    // this.counties = counties;
    // }
    //
    // public List<Tract2000> getTracts() {
    // if (tracts == null) {
    // tracts = new ArrayList<Tract2000>();
    // }
    // return tracts;
    // }
    //
    // public void setTracts(List<Tract2000> tracts) {
    // this.tracts = tracts;
    // }
    //
    // public List<Block2000> getBlocks() {
    // if (blocks == null) {
    // blocks = new ArrayList<Block2000>();
    // }
    // return blocks;
    // }
    //
    // public void setBlocks(List<Block2000> blocks) {
    // this.blocks = blocks;
    // }
    //
    // public List<Place> getPlaces() {
    // if (places == null) {
    // places = new ArrayList<Place>();
    // }
    // return places;
    // }
    //
    // public void setPlaces(List<Place> places) {
    // this.places = places;
    // }
    //
    // public List<StateSenateDistrict> getStateSenateDistricts() {
    // if (stateSenateDistricts == null) {
    // stateSenateDistricts = new ArrayList<StateSenateDistrict>();
    // }
    // return stateSenateDistricts;
    // }
    //
    // public void setStateSenateDistricts(List<StateSenateDistrict>
    // stateSenateDistricts) {
    // this.stateSenateDistricts = stateSenateDistricts;
    // }
    //
    // public List<StateHouseDistrict> getStateHouseDistricts() {
    // if (stateHouseDistricts == null) {
    // stateHouseDistricts = new ArrayList<StateHouseDistrict>();
    // }
    // return stateHouseDistricts;
    // }
    //
    // public void setStateHouseDistricts(List<StateHouseDistrict>
    // stateHouseDistricts) {
    // this.stateHouseDistricts = stateHouseDistricts;
    // }
    //
    // public List<MSA> getMsas() {
    // if (msas == null) {
    // msas = new ArrayList<MSA>();
    // }
    // return msas;
    // }
    //
    // public void setMsas(List<MSA> msas) {
    // this.msas = msas;
    // }
    //
    // public List<CongDistrict> getCongDistricts() {
    // if (congDistricts == null) {
    // congDistricts = new ArrayList<CongDistrict>();
    // }
    // return congDistricts;
    // }
    //
    // public void setCongDistricts(List<CongDistrict> congDistricts) {
    // this.congDistricts = congDistricts;
    // }
    //
    // public void setTribalNations(List<Tribal> tribalNations) {
    // this.tribalNations = tribalNations;
    // }
    //
    // public List<Tribal> getTribalNations() {
    // if (tribalNations == null){
    // tribalNations = new ArrayList<Tribal>();
    // }
    // return tribalNations;
    // }
    //
    // public void setUsfList(List<Usf> usfList) {
    // this.usfList = usfList;
    // }
    //
    // public List<Usf> getUsfList() {
    // if (usfList == null){
    // usfList = new ArrayList<Usf>();
    // }
    // return usfList;
    // }
}