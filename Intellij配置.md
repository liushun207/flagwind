# Intellij ����

��ǩ���ո�ָ����� java

---

Ŀ¼

[TOC]

---

## �����װ

> 
1. `JavaDoc` ��ݼ� shift+alt+g �� control+shift+alt+g
2. `Key promoter`����ݼ���ʾ��
3. `jrebel`���Ȳ�����
4. `Maven Helper`
5. `FindBugs-IDEA`
6. `CheckStyle-IDEA`
7. `GsonFormat`

## JavaDoc
```
other command line:
    -encoding utf-8 -charset utf-8  
```

## CheckStyle-IDEA

```
checkstyle.xml �ļ���
<?xml version="1.0"?>
<!DOCTYPE module PUBLIC
        "-//Puppy Crawl//DTD Check Configuration 1.3//EN"
        "http://www.puppycrawl.com/dtds/configuration_1_3.dtd">

<module name="Checker">
    <!--
        If you set the basedir property below, then all reported file
        names will be relative to the specified directory. See
        http://checkstyle.sourceforge.net/5.x/config.html#Checker
        <property name="basedir" value="${basedir}"/>
    -->
    <!-- ���ÿ�������Ƿ���javaע���ļ���Ĭ����package-info.java -->
    <!-- <module name="JavadocPackage"/> -->
    <!-- ����ļ��Ƿ���һ�����н��� -->
    <module name="NewlineAtEndOfFile"/>

    <!-- ���property�ļ����Ƿ�����ͬ��key -->
    <module name="Translation"/>
    <!-- �ļ����Ȳ�����1500�� -->
    <module name="FileLength">
        <property name="max" value="1500"/>
    </module>

    <!-- ����ļ����Ƿ���'\t' -->
    <module name="FileTabCharacter"/>

    <!-- Miscellaneous other checks. -->
    <module name="RegexpSingleline">
        <property name="format" value="\s+$"/>
        <property name="minimum" value="0"/>
        <property name="maximum" value="0"/>
        <property name="message" value="Line has trailing spaces."/>
    </module>

    <!-- ÿ��java�ļ�һ���﷨�� -->
    <module name="TreeWalker">
        <!-- ע�ͼ�� -->
        <!-- ��鷽���͹��캯����javadoc -->
        <module name="JavadocMethod">
            <property name="tokens" value="METHOD_DEF" />
        </module>
        <!-- �����ͽӿڵ�javadoc��Ĭ�ϲ����author��version tags -->
        <module name="JavadocType"/>
        <!-- ��������javadoc -->
        <module name="JavadocVariable"/>
        <!-- ���javadoc�ĸ�ʽ -->
        <module name="JavadocStyle">
            <property name="checkFirstSentence" value="false"/>
        </module>
        <!-- ���TODO:ע�� -->
        <module name="TodoComment"/>

        <!-- ������� -->
        <!-- �ֲ���final����������catch�еĲ����ļ�� -->
        <module name="LocalFinalVariableName" />
        <!-- �ֲ��ķ�final�͵ı���������catch�еĲ����ļ�� -->
        <module name="LocalVariableName" />
        <!-- �����ļ�飨ֻ����Сд��ĸ����Ĭ��^[a-z]+(\.[a-zA-Z_][a-zA-Z_0-9_]*)*$ -->
        <module name="PackageName">
            <property name="format" value="^[a-z]+(\.[a-z][a-z0-9]*)*$" />
            <message key="name.invalidPattern" value="���� ''{0}'' Ҫ���� ''{1}''��ʽ."/>
        </module>
        <!-- ������static�͵ı�����������static final�ͣ��ļ�� -->
        <module name="StaticVariableName" />
        <!-- Class��Interface����飬Ĭ��^[A-Z][a-zA-Z0-9]*$-->
        <module name="TypeName">
            <property name="severity" value="warning"/>
            <message key="name.invalidPattern" value="���� ''{0}'' Ҫ���� ''{1}''��ʽ."/>
        </module>
        <!-- ��static�ͱ����ļ�� -->
        <module name="MemberName" />
        <!-- �������ļ�� -->
        <module name="MethodName" />
        <!-- �����Ĳ����� -->
        <module name="ParameterName " />
        <!-- �������ļ�飨ֻ�����д����Ĭ��^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$ -->
        <module name="ConstantName" />

        <!-- ������ -->
        <!-- ����������Ͷ������ʽ -->
        <module name="ArrayTypeStyle"/>
        <!-- ��鷽���������캯����catch��Ĳ����Ƿ���final�� -->
        <!-- <module name="FinalParameters"/> -->
        <!-- ���long�Ͷ����Ƿ��д�д�ġ�L�� -->
        <module name="UpperEll"/>


        <!-- Checks for Headers                                -->
        <!-- See http://checkstyle.sf.net/config_header.html   -->
        <!-- <module name="Header">                            -->
        <!-- The follow property value demonstrates the ability     -->
        <!-- to have access to ANT properties. In this case it uses -->
        <!-- the ${basedir} property to allow Checkstyle to be run  -->
        <!-- from any directory within a project. See property      -->
        <!-- expansion,                                             -->
        <!-- http://checkstyle.sf.net/config.html#properties        -->
        <!-- <property                                              -->
        <!--     name="headerFile"                                  -->
        <!--     value="${basedir}/java.header"/>                   -->
        <!-- </module> -->

        <!-- Following interprets the header file as regular expressions. -->
        <!-- <module name="RegexpHeader"/>                                -->


        <!-- import���-->
        <!-- ����ʹ��* -->
        <module name="AvoidStarImport"/>
        <!-- ����Ƿ�ӷǷ��İ��е������� -->
        <module name="IllegalImport"/>
        <!-- ����Ƿ����˶���İ� -->
        <module name="RedundantImport"/>
        <!-- û�õ�import��飬���磺1.û�б��õ�2.�ظ���3.import java.lang��4.import �������ͬһ��package�� -->
        <module name="UnusedImports" />

        <!-- ���ȼ�� -->
        <!-- ÿ�в�����150���ַ� -->
        <module name="LineLength">
            <property name="max" value="150" />
        </module>
        <!-- ����������150�� -->
        <module name="MethodLength">
            <property name="tokens" value="METHOD_DEF" />
            <property name="max" value="150" />
        </module>
        <!-- �����Ĳ�������������5���� ���Ҳ��Թ��췽�����м��-->
        <module name="ParameterNumber">
            <property name="max" value="10" />
            <property name="ignoreOverriddenMethods" value="true"/>
            <property name="tokens" value="METHOD_DEF" />
        </module>

        <!-- �ո���-->
        <!-- �����������Բ����"(" -->
        <module name="MethodParamPad" />
        <!-- ������ת��ʱ����������Բ�����ұ��пո�Ҳ����������Բ��������пո� -->
        <module name="TypecastParenPad" />
        <!-- Iterator -->
        <!-- <module name="EmptyForIteratorPad"/> -->
        <!-- �������� -->
        <!-- <module name="GenericWhitespace"/> -->
        <!-- �����ĳ���ض��ؼ���֮��Ӧ�����ո� -->
        <module name="NoWhitespaceAfter"/>
        <!-- �����ĳ���ض��ؼ���֮ǰӦ�����ո� -->
        <module name="NoWhitespaceBefore"/>
        <!-- ���������в��Լ�� -->
        <module name="OperatorWrap"/>
        <!-- Բ���ſհ� -->
        <module name="ParenPad"/>
        <!-- ���ָ����Ƿ��ڿհ�֮�� -->
        <module name="WhitespaceAfter"/>
        <!-- ���ָ�����Χ�Ƿ��пհ� -->
        <module name="WhitespaceAround"/>


        <!-- ���η���� -->
        <!-- ������η���˳���Ƿ�����java���Թ淶��Ĭ��public��protected��private��abstract��static��final��transient��volatile��synchronized��native��strictfp -->
        <module name="ModifierOrder"/>
        <!-- ���ӿں�annotation���Ƿ��ж������η�����ӿڷ�������ʹ��public -->
        <module name="RedundantModifier"/>


        <!-- ������� -->
        <!-- ����Ƿ���Ƕ�״���� -->
        <module name="AvoidNestedBlocks"/>
        <!-- ����Ƿ��пմ���� -->
        <module name="EmptyBlock"/>
        <!-- ����������λ�� -->
        <module name="LeftCurly"/>
        <!-- ��������Ƿ�ȱʧ{} -->
        <module name="NeedBraces"/>
        <!-- ����Ҵ�����λ�� -->
        <module name="RightCurly"/>


        <!-- ������ -->
        <!-- ����Ƿ���ͬһ�г�ʼ�� -->
        <!-- <module name="AvoidInlineConditionals"/> -->
        <!-- ���յĴ���� -->
        <module name="EmptyStatement"/>
        <!-- �������д��equals�������Ƿ���д��hashCode���� -->
        <module name="EqualsHashCode"/>
        <!-- ���ֲ�����������Ƿ����������еı��� -->
        <module name="HiddenField">
            <property name="tokens" value="VARIABLE_DEF"/>
        </module>
        <!-- ����Ƿ�ʹ�ù�������ʵ���� -->
        <module name="IllegalInstantiation"/>
        <!-- ����ӱ��ʽ���Ƿ��и�ֵ���� -->
        <module name="InnerAssignment"/>
        <!-- ����Ƿ���"ħ��"���� -->
        <module name="MagicNumber">
            <property name="ignoreNumbers" value="0, 1"/>
            <property name="ignoreAnnotation" value="true"/>
        </module>
        <!-- ���switch����Ƿ���default -->
        <module name="MissingSwitchDefault"/>
        <!-- ����Ƿ��й��ȸ��ӵĲ������ʽ -->
        <module name="SimplifyBooleanExpression"/>
        <!-- ����Ƿ��й��ڸ��ӵĲ������ش���� -->
        <module name="SimplifyBooleanReturn"/>

        <!-- ����Ƽ�� -->
        <!-- ������Ƿ�Ϊ��չ���l -->
        <!-- <module name="DesignForExtension"/> -->
        <!-- ���ֻ��private���캯�������Ƿ�����Ϊfinal -->
        <module name="FinalClass"/>
        <!-- ��鹤�����Ƿ���putblic�Ĺ����� -->
        <module name="HideUtilityClassConstructor"/>
        <!-- ���ӿ��Ƿ���������� -->
        <module name="InterfaceIsType"/>
        <!-- ������Ա�Ŀɼ��� -->
        <module name="VisibilityModifier"/>


        <!-- ������� -->
        <!-- �ļ���ʹ����System.out.print��
        <module name="GenericIllegalRegexp">
            <property name="format" value="System\.out\.print"/>
        </module>
        <module name="GenericIllegalRegexp">
            <property name="format" value="System\.exit"/>
        </module>
        <module name="GenericIllegalRegexp">
            <property name="format" value="printStackTrace"/>
        </module>-->

        <!-- �������� -->
        <!-- Ȧ���Ӷ�
        <module name="CyclomaticComplexity">
              <property name="max" value="2"/>
        </module> -->
    </module>
</module>
```