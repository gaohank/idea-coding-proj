package cn.gaohank.idea.j2ee.jpa.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

// 指明实体Bean，和数据库关联
@Entity
@ToString
// 包括无参的构造函数
@NoArgsConstructor
// 包括全部参数的构造函数
@AllArgsConstructor
// 该Bean关联的数据库表
@Table(name = "players")
public class Players {
    private int playerno;
    private String name;
    private String initials;
    private Date birthDate;
    private char sex;
    private int joined;
    private String street;
    private String houseno;
    private String postcode;
    private String town;
    private String phoneno;
    private String leagueno;

    @Id
    @Column(name = "playerno", unique = true, nullable = false)
    public int getPlayerno() {
        return playerno;
    }

    public void setPlayerno(int playerno) {
        this.playerno = playerno;
    }

    @Column(name = "name", length = 15, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "initials", nullable = false)
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "sex", nullable = false)
    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Column(name = "joined", nullable = false)
    public int getJoined() {
        return joined;
    }

    public void setJoined(int joined) {
        this.joined = joined;
    }

    @Column(name = "street", nullable = false)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "houseno")
    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    @Column(name = "postcode", length = 6)
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Column(name = "town", nullable = false)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Column(name = "phoneno")
    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    @Column(name = "leagueno")
    public String getLeagueno() {
        return leagueno;
    }

    public void setLeagueno(String leagueno) {
        this.leagueno = leagueno;
    }
}
