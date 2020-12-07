package Battle_Droid.controller;

import Battle_Droid.model.B1;
import Battle_Droid.model.BattleDroid;
import Battle_Droid.model.Droideka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class DroidFactory {
    private final ArrayList<BattleDroid> droidList = new ArrayList<>();
    private final BufferedReader reader;

    public DroidFactory(int count) {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.fillTeam(count);
    }

    public ArrayList<BattleDroid> getDroidList() {
        return this.droidList;
    }

    private void fillTeam(int count) {
        for(int i = 0; i < count; ++i) {
            System.out.println("Choose droid №" + (i + 1));
            try {
                this.droidList.add(this.chooseDroid());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

    }

    private BattleDroid chooseDroid() throws IOException {
        System.out.println("1. B1 Droid\n2. Droideka\n");
        BattleDroid droid = null;
        String enter;
        for(enter = this.reader.readLine(); !enter.equals("1") && !enter.equals("2"); enter = this.reader.readLine()) {
            System.out.println("Invalid request");
        }

        if (enter.equals("1")) {
            droid = new B1();
        }

        if (enter.equals("2")) {
            droid = new Droideka();
        }

        String name = this.nameGenerator();
        droid.setName(name);
        return droid;
    }

    private String nameGenerator() {
        Random x = new Random();
        String[] ArrName = new String[]{"5X7-T", "WV7-4", "E3-9", "3U-5O", "P67-5", "L-0CN", "CJ-M", "O-44", "243-9",
                "0UT-5", "8-VO", "1-PN3", "I8-S", "0-PDT", "DG-PX", "RN-15", "3-KTD", "35-1", "19-8", "46U-3", "5-FS",
                "5TC-H", "Y-A6", "2-4DZ", "CQ-Q", "03-6", "1-8JJ", "XX-O", "Q7-O0", "9-UO9", "72-5", "SZ-4", "S-W1"};
        return ArrName[x.nextInt(32)];
    }
    public void showInfo() {
        for(int i = 1; i <= this.getDroidList().size(); ++i) {
            System.out.println(i + ". " + this.getDroidList().get(i - 1));
        }

    }
}