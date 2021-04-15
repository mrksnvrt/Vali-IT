package ee.bcs.valiit.dto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Cars {

    private String mark;
    private String mudel;
    private int aasta;

    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public String getMudel() {
        return mudel;
    }
    public void setMudel(String mudel) {
        this.mudel = mudel;
    }
    public int getAasta() {
        return aasta;
    }
    public void setAasta(int aasta) {
        this.aasta = aasta;
    }














}
