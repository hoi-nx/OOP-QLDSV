package ltu13b.nhom05.oop.interfaces;

/**
 * Created by Heart Of Dead on 4/23/2017.
 */
public interface CallBackInterfaces {
    void onPanelOfCreditStudent(String mana);//sinh viên tín chỉ
    //void onPanelOfCreditStudent();
    void onPanelOfManager();//panel manager
    void onPanelOfYearlyStudent();////sinh viên niên chế

    void onPanelScoreOfCreditStudentOfManager(String idSv);
    void onBackPanelOfManager();



}
