package com.afcastano.intellij.autovalue;

import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;

import static com.afcastano.intellij.autovalue.AutoValuePluginTestUtils.AUTOVALUE;

public class AutoValuePluginCreateMethodTest extends LightCodeInsightFixtureTestCase {

    private AutoValuePluginTestUtils utils;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        utils = new AutoValuePluginTestUtils(myFixture);
    }

    @Override
    protected String getTestDataPath() {
        return "testData";
    }

    //---- generate create method
    public void testGenerateBasicCreateMethodWorks() {
        utils.runGenerateCreateMethodActions("generatecreatemethod/basic/BasicTestFile_expected.java",
                "generatecreatemethod/basic/BasicTestFile.java",
                AUTOVALUE);
    }

    public void testGeneratCreateMethodIgnoresToBuilder() {
        utils.runGenerateCreateMethodActions("generatecreatemethod/generateignorestobuilder/BasicTestFile_expected.java",
                "generatecreatemethod/generateignorestobuilder/BasicTestFile.java",
                AUTOVALUE);
    }


    public void testGenerateBasicCreateMethodWorksWhenBuilderExists() {
        utils.runGenerateCreateMethodActions("generatecreatemethod/builderexist/Test_expected.java",
                "generatecreatemethod/builderexist/Test.java",
                AUTOVALUE);
    }

    public void testGenerateBasicCreateMethodWithBuilderIgnoresToBuilder() {
        utils.runGenerateCreateMethodActions("generatecreatemethod/builderexistignorestobuilder/Test_expected.java",
                "generatecreatemethod/builderexistignorestobuilder/Test.java",
                AUTOVALUE);
    }

    public void testUpdateWhenAddNewPropertyAtTheEnd() {
        utils.runUpdateMethodsActions("generatecreatemethod/addNewPropertyAtTheEnd/Test_expected.java",
                "generatecreatemethod/addNewPropertyAtTheEnd/Test.java",
                AUTOVALUE);
    }

    public void testUpdateIgnoresBuilder() {
        utils.runUpdateMethodsActions("generatecreatemethod/upadteignorestobuilder/Test_expected.java",
                "generatecreatemethod/upadteignorestobuilder/Test.java",
                AUTOVALUE);
    }

    public void testUpdateWhenAddNewPropertyInTheMiddle() {
        utils.runUpdateMethodsActions("generatecreatemethod/addNewPropertyInTheMiddle/Test_expected.java",
                "generatecreatemethod/addNewPropertyInTheMiddle/Test.java",
                AUTOVALUE);
    }

    public void testRemovePropertyAtTheEnd() {
        utils.runUpdateMethodsActions("generatecreatemethod/removeLastProperty/Test_expected.java",
                "generatecreatemethod/removeLastProperty/Test.java",
                AUTOVALUE);
    }

    public void testRemovePropertyInTheMiddle() {
        utils.runUpdateMethodsActions("generatecreatemethod/removePropertyInTheMiddle/Test_expected.java",
                "generatecreatemethod/removePropertyInTheMiddle/Test.java",
                AUTOVALUE);
    }

    public void testUpdateBuilderWhenCreateOk() {
        utils.runUpdateMethodsActions("generatecreatemethod/updateBuilderWhenCreateOk/Test_expected.java",
                "generatecreatemethod/updateBuilderWhenCreateOk/Test.java",
                AUTOVALUE);
    }

    public void testUpdateCreateWhenBuilderOk() {
        utils.runUpdateMethodsActions("generatecreatemethod/updateCreateWhenBuilderOk/Test_expected.java",
                "generatecreatemethod/updateCreateWhenBuilderOk/Test.java",
                AUTOVALUE);
    }

    public void testGenerateOkWhenNoMethod() {
        utils.runGenerateCreateMethodActions("generatecreatemethod/nomethods/Test_expected.java",
                "generatecreatemethod/nomethods/Test.java",
                AUTOVALUE);
    }

    public void testUpdateOkWhenNoMethod() {
        utils.runUpdateMethodsActions("generatecreatemethod/nomethods/Test.java",
                "generatecreatemethod/nomethods/Test.java",
                AUTOVALUE);
    }

    public void testUpdateCreateMethodOnly() {
        utils.runUpdateMethodsActions("generatecreatemethod/updateCreateMethodOnly/Test_expected.java",
                "generatecreatemethod/updateCreateMethodOnly/Test.java",
                AUTOVALUE);
    }

    public void testUpdateWhenBuilderIsRemoved() {
        utils.runUpdateMethodsActions("generatecreatemethod/removeBuilderWhenCreateExist/Test_expected.java",
                "generatecreatemethod/removeBuilderWhenCreateExist/Test.java",
                AUTOVALUE);
    }

    public void testGenerateBuilderWithInterfaceHierarchy() {
        utils.runGenerateCreateMethodActions("generatecreatemethod/withinterfacehierarchy/BasicTestFile_expected.java",
                "generatecreatemethod/withinterfacehierarchy/BasicTestFile.java",
                "test/Interface1.java",
                "test/i2/Interface2.java",
                "test/i3/Interface3.java",
                AUTOVALUE);
    }

    public void testGenerateBuilderWithInterfaceIgnoringBlacklisted() {
        utils.runGenerateCreateMethodActions("generatecreatemethod/withinterfaceignoresblacklisted/BasicTestFile_expected.java",
                "generatecreatemethod/withinterfaceignoresblacklisted/BasicTestFile.java",
                "test/Interface1.java",
                "java/util/Map.java",
                "android/os/Parcelable.java",
                AUTOVALUE);
    }

}
