

public class ReportCard {

    String mName;
    String mEnglishGrade;
    String mChemistryGrade;
    String mMathGrade;
    String mBiologyGrade;

    public ReportCard(String aName)
    {
        mName = aName;
        mEnglishGrade = "No grade";
        mMathGrade = "No grade";
        mBiologyGrade = "No grade";
        mChemistryGrade = "No grade";
    }

    public String getEnglishGrade()
    {
        return mEnglishGrade;
    }

    public void setEnglishGrade(String aGrade)
    {
        mEnglishGrade = aGrade;
    }

    public String getMathGrade()
    {
        return mMathGrade;
    }

    public void setMathGrade(String aGrade)
    {
        mMathGrade = aGrade;
    }

    public String getBiologyGrade()
    {
        return mBiologyGrade;
    }

    public void setBiologyGrade(String aGrade)
    {
        mBiologyGrade = aGrade;
    }

    public String getChemistryGrade()
    {
        return mChemistryGrade;
    }

    public void setChemistryGrade(String aGrade)
    {
        mChemistryGrade = aGrade;
    }

    public String toString()
    {
        return "Name: " + mName + "\n"
                + "English Grade: " + mEnglishGrade + "\n"
                + "History Grade: " + mBiologyGrade + "\n"
                + "Math Grade: " + mMathGrade + "\n"
                + "Chemistry Grade: " + mChemistryGrade + "\n";
    }
}
