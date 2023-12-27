package bg.sofia.uni.fmi.mjt.space;

import bg.sofia.uni.fmi.mjt.space.exception.TimeFrameMismatchException;
import bg.sofia.uni.fmi.mjt.space.mission.MissionStatus;
import bg.sofia.uni.fmi.mjt.space.rocket.RocketStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MJTSpaceScannerTest {
    private static MJTSpaceScanner spaceScanner;

    /*static Reader missionReader = new BufferedReader(
        new StringReader("Unnamed: 0,Company Name,Location,Datum,Detail,Status Rocket,\" Rocket\",Status Mission" +
            System.lineSeparator() +
            "0,SpaceX,\"LC-39A, Kennedy Space Center, Florida, USA\",\"Fri Aug 07, 2020\",Falcon 9 Block 5 | Starlink V1 L9 & BlackSky,StatusActive,\"50.0 \",Success" +
            "1,CASC,\"Site 9401 (SLS-2), Jiuquan Satellite Launch Center, China\",\"Thu Aug 06, 2020\",Long March 2D | Gaofen-9 04 & Q-SAT,StatusActive,\"29.75 \",Success" +
            System.lineSeparator() +
            "2,SpaceX,\"Pad A, Boca Chica, Texas, USA\",\"Tue Aug 04, 2020\",Starship Prototype | 150 Meter Hop,StatusActive,,Success" +
            System.lineSeparator() +
            "3,Roscosmos,\"Site 200/39, Baikonur Cosmodrome, Kazakhstan\",\"Thu Jul 30, 2020\",Proton-M/Briz-M | Ekspress-80 & Ekspress-103,StatusActive,\"65.0 \",Success" +
            System.lineSeparator() +
            "4,ULA,\"SLC-41, Cape Canaveral AFS, Florida, USA\",\"Thu Jul 30, 2020\",Atlas V 541 | Perseverance,StatusActive,\"145.0 \",Success" +
            System.lineSeparator() +
            "5,CASC,\"LC-9, Taiyuan Satellite Launch Center, China\",\"Sat Jul 25, 2020\",\"Long March 4B | Ziyuan-3 03, Apocalypse-10 & NJU-HKU 1\",StatusActive,\"64.68 \",Success" +
            System.lineSeparator() +
            "6,Roscosmos,\"Site 31/6, Baikonur Cosmodrome, Kazakhstan\",\"Thu Jul 23, 2020\",Soyuz 2.1a | Progress MS-15,StatusActive,\"48.5 \",Success" +
            System.lineSeparator() +
            "7,CASC,\"LC-101, Wenchang Satellite Launch Center, China\",\"Thu Jul 23, 2020\",Long March 5 | Tianwen-1,StatusActive,,Success" +
            System.lineSeparator() +
            "8,SpaceX,\"SLC-40, Cape Canaveral AFS, Florida, USA\",\"Mon Jul 20, 2020\",Falcon 9 Block 5 | ANASIS-II,StatusActive,\"50.0 \",Success" +
            System.lineSeparator() +
            "9,JAXA,\"LA-Y1, Tanegashima Space Center, Japan\",\"Sun Jul 19, 2020\",H-IIA 202 | Hope Mars Mission,StatusActive,\"90.0 \",Success" +
            System.lineSeparator() +
            "10,Northrop,\"LP-0B, Wallops Flight Facility, Virginia, USA\",\"Wed Jul 15, 2020\",Minotaur IV | NROL-129,StatusActive,\"46.0 \",Success" +
            System.lineSeparator() +
            "11,ExPace,\"Site 95, Jiuquan Satellite Launch Center, China\",\"Fri Jul 10, 2020\",\"Kuaizhou 11 | Jilin-1 02E, CentiSpace-1 S2\",StatusActive,\"28.3 \",Failure" +
            System.lineSeparator() +
            "12,CASC,\"LC-3, Xichang Satellite Launch Center, China\",\"Thu Jul 09, 2020\",Long March 3B/E | Apstar-6D,StatusActive,\"29.15 \",Success" +
            System.lineSeparator() +
            "13,IAI,\"Pad 1, Palmachim Airbase, Israel\",\"Mon Jul 06, 2020\",Shavit-2 | Ofek-16,StatusActive,,Success" +
            System.lineSeparator() +
            "14,CASC,\"Site 9401 (SLS-2), Jiuquan Satellite Launch Center, China\",\"Sat Jul 04, 2020\",Long March 2D | Shiyan-6 02,StatusActive,\"29.75 \",Success" +
            System.lineSeparator() +
            "15,Rocket Lab,\"Rocket Lab LC-1A, M?\u0081hia Peninsula, New Zealand\",\"Sat Jul 04, 2020\",Electron/Curie | Pics Or It Didn??¦t Happen,StatusActive,\"7.5 \",Failure" +
            System.lineSeparator() +
            "16,CASC,\"LC-9, Taiyuan Satellite Launch Center, China\",\"Fri Jul 03, 2020\",Long March 4B | Gaofen Duomo & BY-02,StatusActive,\"64.68 \",Success" +
            System.lineSeparator() +
            "17,SpaceX,\"SLC-40, Cape Canaveral AFS, Florida, USA\",\"Tue Jun 30, 2020\",Falcon 9 Block 5 | GPS III SV03,StatusActive,\"50.0 \",Success" +
            System.lineSeparator() +
            "18,CASC,\"LC-2, Xichang Satellite Launch Center, China\",\"Tue Jun 23, 2020\",Long March 3B/E | Beidou-3 G3,StatusActive,\"29.15 \",Success" +
            System.lineSeparator() +
            "19,CASC,\"Site 9401 (SLS-2), Jiuquan Satellite Launch Center, China\",\"Wed Jun 17, 2020\",\"Long March 2D | Gaofen-9 03, Pixing III A & HEAD-5\",StatusActive,\"29.75 \",Success" +
            System.lineSeparator() +
            "20,SpaceX,\"SLC-40, Cape Canaveral AFS, Florida, USA\",\"Sat Jun 13, 2020\",Falcon 9 Block 5 | Starlink V1 L8 & SkySat 16 to 18,StatusActive,\"50.0 \",Success" +
            System.lineSeparator() +
            "21,Rocket Lab,\"Rocket Lab LC-1A, M?\u0081hia Peninsula, New Zealand\",\"Sat Jun 13, 2020\",Electron/Curie | Don't stop me now!,StatusActive,\"7.5 \",Success" +
            System.lineSeparator() +
            "22,CASC,\"LC-9, Taiyuan Satellite Launch Center, China\",\"Wed Jun 10, 2020\",Long March 2C | Haiyang-1D,StatusActive,\"30.8 \",Success" +
            System.lineSeparator() +
            "23,SpaceX,\"SLC-40, Cape Canaveral AFS, Florida, USA\",\"Thu Jun 04, 2020\",Falcon 9 Block 5 | Starlink V1 L7,StatusActive,\"50.0 \",Success" +
            System.lineSeparator() +
            "24,CASC,\"Site 9401 (SLS-2), Jiuquan Satellite Launch Center, China\",\"Sun May 31, 2020\",Long March 2D | Gaofen-9-02 & HEAD-4,StatusActive,\"29.75 \",Success" +
            System.lineSeparator() +
            "25,SpaceX,\"LC-39A, Kennedy Space Center, Florida, USA\",\"Sat May 30, 2020\",Falcon 9 Block 5 | SpaceX Demo-2,StatusActive,\"50.0 \",Success" +
            System.lineSeparator() +
            "26,CASC,\"Xichang Satellite Launch Center, China\",\"Fri May 29, 2020\",Long March 11 | XJS-G and XJS-H,StatusActive,\"5.3 \",Success" +
            System.lineSeparator() +
            "27,Virgin Orbit,\"Cosmic Girl, Mojave Air and Space Port, California, USA\",\"Mon May 25, 2020\",LauncherOne | Demo Flight,StatusActive,\"12.0 \",Failure" +
            System.lineSeparator() +
            "28,VKS RF,\"Site 43/4, Plesetsk Cosmodrome, Russia\",\"Fri May 22, 2020\",Soyuz 2.1b/Fregat-M | Cosmos 2546,StatusActive,,Success" +
            System.lineSeparator() +
            "29,MHI,\"LA-Y2, Tanegashima Space Center, Japan\",\"Wed May 20, 2020\",H-IIB | HTV-9,StatusRetired,\"112.5 \",Success" +
            System.lineSeparator() +
            "30,ULA,\"SLC-41, Cape Canaveral AFS, Florida, USA\",\"Sun May 17, 2020\",Atlas V 501 | OTV-6 (USSF-7),StatusActive,\"120.0 \",Success" +
            System.lineSeparator() +
            "31,ExPace,\"Site 95, Jiuquan Satellite Launch Center, China\",\"Tue May 12, 2020\",Kuaizhou 1A | Xingyun-2 01 (Wuhan) & 02,StatusActive,,Success" +
            System.lineSeparator() +
            "32,CASC,\"LC-101, Wenchang Satellite Launch Center, China\",\"Tue May 05, 2020\",Long March 5B | Test Flight (New Crew Capsule),StatusActive,,Success" +
            System.lineSeparator() +
            "33,Roscosmos,\"Site 31/6, Baikonur Cosmodrome, Kazakhstan\",\"Sat Apr 25, 2020\",Soyuz 2.1a | Progress MS-14,StatusActive,\"48.5 \",Success" +
            System.lineSeparator() +
            "34,SpaceX,\"LC-39A, Kennedy Space Center, Florida, USA\",\"Wed Apr 22, 2020\",Falcon 9 Block 5 | Starlink V1 L6,StatusActive,\"50.0 \",Success" +
            System.lineSeparator() +
            "35,IRGC,\"Launch Plateform, Shahrud Missile Test Site\",\"Wed Apr 22, 2020\",Qased | Noor 1,StatusActive,,Success" +
            System.lineSeparator() +
            "36,CASC,\"LC-2, Xichang Satellite Launch Center, China\",\"Thu Apr 09, 2020\",Long March 3B/E | Nusantara Dua,StatusActive,\"29.15 \",Failure" +
            System.lineSeparator() +
            "37,Roscosmos,\"Site 31/6, Baikonur Cosmodrome, Kazakhstan\",\"Thu Apr 09, 2020\",Soyuz 2.1a | Soyuz MS-16,StatusActive,\"48.5 \",Success" +
            System.lineSeparator() +
            "38,ULA,\"SLC-41, Cape Canaveral AFS, Florida, USA\",\"Thu Mar 26, 2020\",Atlas V 551 | AEHF 6,StatusActive,\"153.0 \",Success" +
            System.lineSeparator() +
            "39,CASC,\"LC-3, Xichang Satellite Launch Center, China\",\"Tue Mar 24, 2020\",Long March 2C | Yaogan-30-06,StatusActive,\"30.8 \",Success" +
            System.lineSeparator() +
            "40,Arianespace,\"Site 31/6, Baikonur Cosmodrome, Kazakhstan\",\"Sat Mar 21, 2020\",Soyuz 2.1b/Fregat | OneWeb #3,StatusActive,\"48.5 \",Success" +
            System.lineSeparator() +
            "41,SpaceX,\"LC-39A, Kennedy Space Center, Florida, USA\",\"Wed Mar 18, 2020\",Falcon 9 Block 5 | Starlink V1 L5,StatusActive,\"50.0 \",Success" +
            System.lineSeparator() +
            "42,VKS RF,\"Site 43/4, Plesetsk Cosmodrome, Russia\",\"Mon Mar 16, 2020\",Soyuz 2.1b/Fregat-M | Cosmos 2545,StatusActive,,Success" +
            System.lineSeparator() +
            "43,CASC,\"LC-201, Wenchang Satellite Launch Center, China\",\"Mon Mar 16, 2020\",Long March 7A | XJY-6,StatusActive,,Failure" +
            System.lineSeparator() +
            "44,CASC,\"LC-2, Xichang Satellite Launch Center, China\",\"Mon Mar 09, 2020\",Long March 3B/E | Beidou-3 G2,StatusActive,\"29.15 \",Success" +
            System.lineSeparator() +
            "45,SpaceX,\"SLC-40, Cape Canaveral AFS, Florida, USA\",\"Sat Mar 07, 2020\",Falcon 9 Block 5 | CRS-20,StatusActive,\"50.0 \",Success" +
            System.lineSeparator() +
            "46,VKS RF,\"Site 43/3, Plesetsk Cosmodrome, Russia\",\"Thu Feb 20, 2020\",Soyuz 2.1a/Fregat-M | Meridian-M n†\u00AD19L,StatusActive,\"48.5 \",Success" +
            System.lineSeparator() +
            "47,CASC,\"LC-3, Xichang Satellite Launch Center, China\",\"Wed Feb 19, 2020\",Long March 2D | XJS-C to F,StatusActive,\"29.75 \",Success" +
            System.lineSeparator() +
            "48,Arianespace,\"ELA-3, Guiana Space Centre, French Guiana, France\",\"Tue Feb 18, 2020\",Ariane 5 ECA | JCSAT-17 & GEO-KOMPSAT 2B,StatusActive,\"200.0 \",Success"));*/

    static Reader missionReader = new BufferedReader(
        new StringReader("Unnamed: 0,Company Name,Location,Datum,Detail,Status Rocket,\" Rocket\",Status Mission\n" +
            "0,SpaceX,\"LC-39A, Kennedy Space Center, Florida, USA\",\"Fri Aug 07, 2020\",Falcon 9 Block 5 | Starlink V1 L9 & BlackSky,StatusActive,\"50.0 \",Success\n" +
            "1,CASC,\"Site 9401 (SLS-2), Jiuquan Satellite Launch Center, China\",\"Thu Aug 06, 2020\",Long March 2D | Gaofen-9 04 & Q-SAT,StatusActive,\"29.75 \",Success\n" +
            "2,SpaceX,\"Pad A, Boca Chica, Texas, USA\",\"Tue Aug 04, 2020\",Starship Prototype | 150 Meter Hop,StatusActive,,Success\n" +
            "3,Roscosmos,\"Site 200/39, Baikonur Cosmodrome, Kazakhstan\",\"Thu Jul 30, 2020\",Proton-M/Briz-M | Ekspress-80 & Ekspress-103,StatusActive,\"65.0 \",Success\n" +
            "4,ULA,\"SLC-41, Cape Canaveral AFS, Florida, USA\",\"Thu Jul 30, 2020\",Atlas V 541 | Perseverance,StatusActive,\"145.0 \",Success\n" +
            "5,CASC,\"LC-9, Taiyuan Satellite Launch Center, China\",\"Sat Jul 25, 2020\",\"Long March 4B | Ziyuan-3 03, Apocalypse-10 & NJU-HKU 1\",StatusActive,\"64.68 \",Success\n" +
            "6,Roscosmos,\"Site 31/6, Baikonur Cosmodrome, Kazakhstan\",\"Thu Jul 23, 2020\",Soyuz 2.1a | Progress MS-15,StatusActive,\"48.5 \",Success\n" +
            "7,CASC,\"LC-101, Wenchang Satellite Launch Center, China\",\"Thu Jul 23, 2020\",Long March 5 | Tianwen-1,StatusActive,,Success\n" +
            "8,SpaceX,\"SLC-40, Cape Canaveral AFS, Florida, USA\",\"Mon Jul 20, 2020\",Falcon 9 Block 5 | ANASIS-II,StatusActive,\"50.0 \",Success\n" +
            "9,JAXA,\"LA-Y1, Tanegashima Space Center, Japan\",\"Sun Jul 19, 2020\",H-IIA 202 | Hope Mars Mission,StatusActive,\"90.0 \",Success\n" +
            "10,Northrop,\"LP-0B, Wallops Flight Facility, Virginia, USA\",\"Wed Jul 15, 2020\",Minotaur IV | NROL-129,StatusActive,\"46.0 \",Success\n" +
            "11,ExPace,\"Site 95, Jiuquan Satellite Launch Center, China\",\"Fri Jul 10, 2020\",\"Kuaizhou 11 | Jilin-1 02E, CentiSpace-1 S2\",StatusActive,\"28.3 \",Failure\n" +
            "12,CASC,\"LC-3, Xichang Satellite Launch Center, China\",\"Thu Jul 09, 2020\",Long March 3B/E | Apstar-6D,StatusActive,\"29.15 \",Success\n" +
            "13,IAI,\"Pad 1, Palmachim Airbase, Israel\",\"Mon Jul 06, 2020\",Shavit-2 | Ofek-16,StatusActive,,Success\n" +
            "14,CASC,\"Site 9401 (SLS-2), Jiuquan Satellite Launch Center, China\",\"Sat Jul 04, 2020\",Long March 2D | Shiyan-6 02,StatusActive,\"29.75 \",Success\n" +
            "15,Rocket Lab,\"Rocket Lab LC-1A, M?\u0081hia Peninsula, New Zealand\",\"Sat Jul 04, 2020\",Electron/Curie | Pics Or It Didn??¦t Happen,StatusActive,\"7.5 \",Failure\n" +
            "16,CASC,\"LC-9, Taiyuan Satellite Launch Center, China\",\"Fri Jul 03, 2020\",Long March 4B | Gaofen Duomo & BY-02,StatusActive,\"64.68 \",Success\n" +
            "17,SpaceX,\"SLC-40, Cape Canaveral AFS, Florida, USA\",\"Tue Jun 30, 2020\",Falcon 9 Block 5 | GPS III SV03,StatusActive,\"50.0 \",Success\n" +
            "18,CASC,\"LC-2, Xichang Satellite Launch Center, China\",\"Tue Jun 23, 2020\",Long March 3B/E | Beidou-3 G3,StatusActive,\"29.15 \",Success\n" +
            "19,CASC,\"Site 9401 (SLS-2), Jiuquan Satellite Launch Center, China\",\"Wed Jun 17, 2020\",\"Long March 2D | Gaofen-9 03, Pixing III A & HEAD-5\",StatusActive,\"29.75 \",Success\n" +
            "20,SpaceX,\"SLC-40, Cape Canaveral AFS, Florida, USA\",\"Sat Jun 13, 2020\",Falcon 9 Block 5 | Starlink V1 L8 & SkySat 16 to 18,StatusActive,\"50.0 \",Success\n" +
            "21,Rocket Lab,\"Rocket Lab LC-1A, M?\u0081hia Peninsula, New Zealand\",\"Sat Jun 13, 2020\",Electron/Curie | Don't stop me now!,StatusActive,\"7.5 \",Success\n" +
            "22,CASC,\"LC-9, Taiyuan Satellite Launch Center, China\",\"Wed Jun 10, 2020\",Long March 2C | Haiyang-1D,StatusActive,\"30.8 \",Success\n" +
            "23,SpaceX,\"SLC-40, Cape Canaveral AFS, Florida, USA\",\"Thu Jun 04, 2020\",Falcon 9 Block 5 | Starlink V1 L7,StatusActive,\"50.0 \",Success\n" +
            "24,CASC,\"Site 9401 (SLS-2), Jiuquan Satellite Launch Center, China\",\"Sun May 31, 2020\",Long March 2D | Gaofen-9-02 & HEAD-4,StatusActive,\"29.75 \",Success\n" +
            "25,SpaceX,\"LC-39A, Kennedy Space Center, Florida, USA\",\"Sat May 30, 2020\",Falcon 9 Block 5 | SpaceX Demo-2,StatusActive,\"50.0 \",Success\n" +
            "26,CASC,\"Xichang Satellite Launch Center, China\",\"Fri May 29, 2020\",Long March 11 | XJS-G and XJS-H,StatusActive,\"5.3 \",Success\n" +
            "27,Virgin Orbit,\"Cosmic Girl, Mojave Air and Space Port, California, USA\",\"Mon May 25, 2020\",LauncherOne | Demo Flight,StatusActive,\"12.0 \",Failure\n" +
            "28,VKS RF,\"Site 43/4, Plesetsk Cosmodrome, Russia\",\"Fri May 22, 2020\",Soyuz 2.1b/Fregat-M | Cosmos 2546,StatusActive,,Success\n" +
            "29,MHI,\"LA-Y2, Tanegashima Space Center, Japan\",\"Wed May 20, 2020\",H-IIB | HTV-9,StatusRetired,\"112.5 \",Success\n" +
            "30,ULA,\"SLC-41, Cape Canaveral AFS, Florida, USA\",\"Sun May 17, 2020\",Atlas V 501 | OTV-6 (USSF-7),StatusActive,\"120.0 \",Success\n" +
            "31,ExPace,\"Site 95, Jiuquan Satellite Launch Center, China\",\"Tue May 12, 2020\",Kuaizhou 1A | Xingyun-2 01 (Wuhan) & 02,StatusActive,,Success\n" +
            "32,CASC,\"LC-101, Wenchang Satellite Launch Center, China\",\"Tue May 05, 2020\",Long March 5B | Test Flight (New Crew Capsule),StatusActive,,Success\n" +
            "33,Roscosmos,\"Site 31/6, Baikonur Cosmodrome, Kazakhstan\",\"Sat Apr 25, 2020\",Soyuz 2.1a | Progress MS-14,StatusActive,\"48.5 \",Success\n" +
            "34,SpaceX,\"LC-39A, Kennedy Space Center, Florida, USA\",\"Wed Apr 22, 2020\",Falcon 9 Block 5 | Starlink V1 L6,StatusActive,\"50.0 \",Success\n" +
            "35,IRGC,\"Launch Plateform, Shahrud Missile Test Site\",\"Wed Apr 22, 2020\",Qased | Noor 1,StatusActive,,Success\n" +
            "36,CASC,\"LC-2, Xichang Satellite Launch Center, China\",\"Thu Apr 09, 2020\",Long March 3B/E | Nusantara Dua,StatusActive,\"29.15 \",Failure\n" +
            "37,Roscosmos,\"Site 31/6, Baikonur Cosmodrome, Kazakhstan\",\"Thu Apr 09, 2020\",Soyuz 2.1a | Soyuz MS-16,StatusActive,\"48.5 \",Success\n" +
            "38,ULA,\"SLC-41, Cape Canaveral AFS, Florida, USA\",\"Thu Mar 26, 2020\",Atlas V 551 | AEHF 6,StatusActive,\"153.0 \",Success\n" +
            "39,CASC,\"LC-3, Xichang Satellite Launch Center, China\",\"Tue Mar 24, 2020\",Long March 2C | Yaogan-30-06,StatusActive,\"30.8 \",Success\n" +
            "40,Arianespace,\"Site 31/6, Baikonur Cosmodrome, Kazakhstan\",\"Sat Mar 21, 2020\",Soyuz 2.1b/Fregat | OneWeb #3,StatusActive,\"48.5 \",Success\n" +
            "41,SpaceX,\"LC-39A, Kennedy Space Center, Florida, USA\",\"Wed Mar 18, 2020\",Falcon 9 Block 5 | Starlink V1 L5,StatusActive,\"50.0 \",Success\n" +
            "42,VKS RF,\"Site 43/4, Plesetsk Cosmodrome, Russia\",\"Mon Mar 16, 2020\",Soyuz 2.1b/Fregat-M | Cosmos 2545,StatusActive,,Success\n" +
            "43,CASC,\"LC-201, Wenchang Satellite Launch Center, China\",\"Mon Mar 16, 2020\",Long March 7A | XJY-6,StatusActive,,Failure\n" +
            "44,CASC,\"LC-2, Xichang Satellite Launch Center, China\",\"Mon Mar 09, 2020\",Long March 3B/E | Beidou-3 G2,StatusActive,\"29.15 \",Success\n" +
            "45,SpaceX,\"SLC-40, Cape Canaveral AFS, Florida, USA\",\"Sat Mar 07, 2020\",Falcon 9 Block 5 | CRS-20,StatusActive,\"50.0 \",Success\n" +
            "46,VKS RF,\"Site 43/3, Plesetsk Cosmodrome, Russia\",\"Thu Feb 20, 2020\",Soyuz 2.1a/Fregat-M | Meridian-M n†\u00AD19L,StatusActive,\"48.5 \",Success\n" +
            "47,CASC,\"LC-3, Xichang Satellite Launch Center, China\",\"Wed Feb 19, 2020\",Long March 2D | XJS-C to F,StatusActive,\"29.75 \",Success\n" +
            "48,Arianespace,\"ELA-3, Guiana Space Centre, French Guiana, France\",\"Tue Feb 18, 2020\",Ariane 5 ECA | JCSAT-17 & GEO-KOMPSAT 2B,StatusActive,\"200.0 \",Success\n"));/**/

    /*static Reader rocketReader =
        new BufferedReader(new StringReader("\"\",Name,Wiki,Rocket Height"
            + System.lineSeparator() +
            "0,Tsyklon-3,https://en.wikipedia.org/wiki/Tsyklon-3,39.0 m"
            + System.lineSeparator() +
            "1,Tsyklon-4M,https://en.wikipedia.org/wiki/Cyclone-4M,38.7 m"
            + System.lineSeparator() +
            "2,Unha-2,https://en.wikipedia.org/wiki/Unha,28.0 m"
            + System.lineSeparator() +
            "3,Unha-3,https://en.wikipedia.org/wiki/Unha,32.0 m"
            + System.lineSeparator() +
            "4,Vanguard,https://en.wikipedia.org/wiki/Vanguard_(rocket),23.0 m"
            + System.lineSeparator() +
            "5,Vector-H,https://en.wikipedia.org/wiki/Vector-H,18.3 m"
            + System.lineSeparator() +
            "6,Vector-R,https://en.wikipedia.org/wiki/Vector-R,13.0 m"
            + System.lineSeparator() +
            "7,Vega,https://en.wikipedia.org/wiki/Vega_(rocket),29.9 m"
            + System.lineSeparator() +
            "8,Vega C,https://en.wikipedia.org/wiki/Vega_(rocket),35.0 m"
            + System.lineSeparator() +
            "9,Vega E,https://en.wikipedia.org/wiki/Vega_(rocket),35.0 m"
            + System.lineSeparator() +
            "10,VLS-1,https://en.wikipedia.org/wiki/VLS-1,19.0 m"
            + System.lineSeparator() +
            "11,Volna,https://en.wikipedia.org/wiki/Volna,15.0 m"
            + System.lineSeparator() +
            "12,Voskhod,https://en.wikipedia.org/wiki/Voskhod_(rocket),31.0 m"
            + System.lineSeparator() +
            "13,Vostok,https://en.wikipedia.org/wiki/Vostok-K,31.0 m"
            + System.lineSeparator() +
            "14,Vostok-2,https://en.wikipedia.org/wiki/Vostok-2_(rocket),"
            + System.lineSeparator() +
            "15,Vostok-2A,https://en.wikipedia.org/wiki/Vostok_(rocket_family),"
            + System.lineSeparator() +
            "16,Vostok-2M,https://en.wikipedia.org/wiki/Vostok-2M,"
            + System.lineSeparator() +
            "17,Vulcan Centaur,https://en.wikipedia.org/wiki/Vulcan_%28rocket%29,58.3 m"
            + System.lineSeparator() +
            "18,Zenit-2,https://en.wikipedia.org/wiki/Zenit-2,57.0 m"
            + System.lineSeparator() +
            "19,Zenit-2 FG,https://en.wikipedia.org/wiki/Zenit_%28rocket_family%29,57.0 m"
            + System.lineSeparator() +
            "20,Zenit-3 SL,https://en.wikipedia.org/wiki/Zenit_%28rocket_family%29,59.6 m"
            + System.lineSeparator() +
            "21,Zenit-3 SLB,https://en.wikipedia.org/wiki/Zenit_%28rocket_family%29,57.0 m"
            + System.lineSeparator() +
            "22,Zenit-3 SLBF,https://en.wikipedia.org/wiki/Zenit-3F,57.0 m"
            + System.lineSeparator() +
            "23,Zéphyr,https://fr.wikipedia.org/wiki/Z%C3%A9phyr_(fus%C3%A9e),12.3 m"
            + System.lineSeparator() +
            "24,ZhuQue-1,https://en.wikipedia.org/wiki/LandSpace,19.0 m"
            + System.lineSeparator() +
            "25,ZhuQue-2,https://en.wikipedia.org/wiki/LandSpace#Zhuque-2,"
            + System.lineSeparator() +
            "26,Angara 1.1,https://en.wikipedia.org/wiki/Angara_(rocket_family),35.0 m"
            + System.lineSeparator() +
            "27,Angara 1.2,https://en.wikipedia.org/wiki/Angara_(rocket_family),41.5 m"
            + System.lineSeparator() +
            "28,Angara A5/Briz-M,https://en.wikipedia.org/wiki/Angara_(rocket_family)#Angara_A5," +
            System.lineSeparator() +
            "29,Angara A5/DM-03,https://en.wikipedia.org/wiki/Angara_(rocket_family)#Angara_A5," +
            System.lineSeparator() +
            "30,Angara A5M,https://en.wikipedia.org/wiki/Angara_(rocket_family)#Angara_A5,"
            + System.lineSeparator() +
            "31,Antares 110,https://en.wikipedia.org/wiki/Antares_(rocket),40.5 m"
            + System.lineSeparator() +
            "32,Antares 120,https://en.wikipedia.org/wiki/Antares_(rocket),40.5 m"
            + System.lineSeparator() +
            "33,Antares 130,https://en.wikipedia.org/wiki/Antares_(rocket),40.5 m"
            + System.lineSeparator() +
            "34,Antares 230,https://en.wikipedia.org/wiki/Antares_(rocket),41.9 m"
            + System.lineSeparator() +
            "35,Antares 230+,https://en.wikipedia.org/wiki/Antares_%28rocket%29#Antares_230+,42.5 m" +
            System.lineSeparator() +
            "36,Ares 1-X,https://en.wikipedia.org/wiki/Ares_I,94.0 m"
            + System.lineSeparator() +
            "37,Ariane 1,https://en.wikipedia.org/wiki/Ariane_1,50.0 m"
            + System.lineSeparator() +
            "38,Ariane 2,https://en.wikipedia.org/wiki/Ariane_2,49.13 m"
            + System.lineSeparator() +
            "39,Ariane 3,https://en.wikipedia.org/wiki/Ariane_3,49.13 m"
            + System.lineSeparator() +
            "40,Ariane 40,https://en.wikipedia.org/wiki/Ariane_4,58.72 m"
            + System.lineSeparator() +
            "41,Ariane 42L,https://en.wikipedia.org/wiki/Ariane_4,58.72 m"
            + System.lineSeparator() +
            "42,Ariane 42P,https://en.wikipedia.org/wiki/Ariane_4,58.72 m"
            + System.lineSeparator() +
            "43,Ariane 44L,https://en.wikipedia.org/wiki/Ariane_4,58.72 m"
            + System.lineSeparator() +
            "44,Ariane 44LP,https://en.wikipedia.org/wiki/Ariane_4,58.72 m"
            + System.lineSeparator() +
            "45,Ariane 44P,https://en.wikipedia.org/wiki/Ariane_4,58.72 m"
            + System.lineSeparator() +
            "46,Ariane 5 ECA,https://en.wikipedia.org/wiki/Ariane_5,53.0 m"
            + System.lineSeparator() +
            "47,Ariane 5 ES,https://en.wikipedia.org/wiki/Ariane_5,50.5 m"
            + System.lineSeparator() +
            "48,Ariane 5 G,https://en.wikipedia.org/wiki/Ariane_5,52.0 m"));

   /**/
    static Reader rocketReader =
        new BufferedReader(new StringReader("\"\",Name,Wiki,Rocket Height\n" +
            "0,Tsyklon-3,https://en.wikipedia.org/wiki/Tsyklon-3,39.0 m\n" +
            "1,Tsyklon-4M,https://en.wikipedia.org/wiki/Cyclone-4M,38.7 m\n" +
            "2,Unha-2,https://en.wikipedia.org/wiki/Unha,28.0 m\n" +
            "3,Unha-3,https://en.wikipedia.org/wiki/Unha,32.0 m\n" +
            "4,Vanguard,https://en.wikipedia.org/wiki/Vanguard_(rocket),23.0 m\n" +
            "5,Vector-H,https://en.wikipedia.org/wiki/Vector-H,18.3 m\n" +
            "6,Vector-R,https://en.wikipedia.org/wiki/Vector-R,13.0 m\n" +
            "7,Vega,https://en.wikipedia.org/wiki/Vega_(rocket),29.9 m\n" +
            "8,Vega C,https://en.wikipedia.org/wiki/Vega_(rocket),35.0 m\n" +
            "9,Vega E,https://en.wikipedia.org/wiki/Vega_(rocket),35.0 m\n" +
            "10,VLS-1,https://en.wikipedia.org/wiki/VLS-1,19.0 m\n" +
            "11,Volna,https://en.wikipedia.org/wiki/Volna,15.0 m\n" +
            "12,Voskhod,https://en.wikipedia.org/wiki/Voskhod_(rocket),31.0 m\n" +
            "13,Vostok,https://en.wikipedia.org/wiki/Vostok-K,31.0 m\n" +
            "14,Vostok-2,https://en.wikipedia.org/wiki/Vostok-2_(rocket),\n" +
            "15,Vostok-2A,https://en.wikipedia.org/wiki/Vostok_(rocket_family),\n" +
            "16,Vostok-2M,https://en.wikipedia.org/wiki/Vostok-2M,\n" +
            "17,Vulcan Centaur,https://en.wikipedia.org/wiki/Vulcan_%28rocket%29,58.3 m\n" +
            "18,Zenit-2,https://en.wikipedia.org/wiki/Zenit-2,57.0 m\n" +
            "19,Zenit-2 FG,https://en.wikipedia.org/wiki/Zenit_%28rocket_family%29,57.0 m\n" +
            "20,Zenit-3 SL,https://en.wikipedia.org/wiki/Zenit_%28rocket_family%29,59.6 m\n" +
            "21,Zenit-3 SLB,https://en.wikipedia.org/wiki/Zenit_%28rocket_family%29,57.0 m\n" +
            "22,Zenit-3 SLBF,https://en.wikipedia.org/wiki/Zenit-3F,57.0 m\n" +
            "23,Zéphyr,https://fr.wikipedia.org/wiki/Z%C3%A9phyr_(fus%C3%A9e),12.3 m\n" +
            "24,ZhuQue-1,https://en.wikipedia.org/wiki/LandSpace,19.0 m\n" +
            "25,ZhuQue-2,https://en.wikipedia.org/wiki/LandSpace#Zhuque-2,\n" +
            "26,Angara 1.1,https://en.wikipedia.org/wiki/Angara_(rocket_family),35.0 m\n" +
            "27,Angara 1.2,https://en.wikipedia.org/wiki/Angara_(rocket_family),41.5 m\n" +
            "28,Angara A5/Briz-M,https://en.wikipedia.org/wiki/Angara_(rocket_family)#Angara_A5,\n" +
            "29,Angara A5/DM-03,https://en.wikipedia.org/wiki/Angara_(rocket_family)#Angara_A5,\n" +
            "30,Angara A5M,https://en.wikipedia.org/wiki/Angara_(rocket_family)#Angara_A5,\n" +
            "31,Antares 110,https://en.wikipedia.org/wiki/Antares_(rocket),40.5 m\n" +
            "32,Antares 120,https://en.wikipedia.org/wiki/Antares_(rocket),40.5 m\n" +
            "33,Antares 130,https://en.wikipedia.org/wiki/Antares_(rocket),40.5 m\n" +
            "34,Antares 230,https://en.wikipedia.org/wiki/Antares_(rocket),41.9 m\n" +
            "35,Antares 230+,https://en.wikipedia.org/wiki/Antares_%28rocket%29#Antares_230+,42.5 m\n" +
            "36,Ares 1-X,https://en.wikipedia.org/wiki/Ares_I,94.0 m\n" +
            "37,Ariane 1,https://en.wikipedia.org/wiki/Ariane_1,50.0 m\n" +
            "38,Ariane 2,https://en.wikipedia.org/wiki/Ariane_2,49.13 m\n" +
            "39,Ariane 3,https://en.wikipedia.org/wiki/Ariane_3,49.13 m\n" +
            "40,Ariane 40,https://en.wikipedia.org/wiki/Ariane_4,58.72 m\n" +
            "41,Ariane 42L,https://en.wikipedia.org/wiki/Ariane_4,58.72 m\n" +
            "42,Ariane 42P,https://en.wikipedia.org/wiki/Ariane_4,58.72 m\n" +
            "43,Ariane 44L,https://en.wikipedia.org/wiki/Ariane_4,58.72 m\n" +
            "44,Ariane 44LP,https://en.wikipedia.org/wiki/Ariane_4,58.72 m\n" +
            "45,Ariane 44P,https://en.wikipedia.org/wiki/Ariane_4,58.72 m\n" +
            "46,Ariane 5 ECA,https://en.wikipedia.org/wiki/Ariane_5,53.0 m\n" +
            "47,Ariane 5 ES,https://en.wikipedia.org/wiki/Ariane_5,50.5 m\n" +
            "48,Ariane 5 G,https://en.wikipedia.org/wiki/Ariane_5,52.0 m"));/**/

    @BeforeAll
    static void setUp() {
        SecretKey key = null;
        spaceScanner = new MJTSpaceScanner(missionReader, rocketReader, key);
    }

    @Test
    void testMJTSpaceScanner() {
        assertThrows(FileNotFoundException.class, () -> {
            BufferedReader missionReader = new BufferedReader(new FileReader("invalidDataPath"));
            Reader rocketReader = new FileReader("invalidDataPath");
            SecretKey key = null;

            spaceScanner = new MJTSpaceScanner(missionReader, rocketReader, key);
        });
    }

    @Test
    void testGetAllMissionsNoParam() {
        assertEquals(49, spaceScanner.getAllMissions().size());
    }

    @Test
    void testGetAllMissionsWithNullParam() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.getAllMissions(null);
        });
    }

    @Test
    void testGetAllMissionsWithParam() {
        assertEquals(44, spaceScanner.getAllMissions(MissionStatus.SUCCESS).size());
        assertEquals(5, spaceScanner.getAllMissions(MissionStatus.FAILURE).size());
        assertEquals(0, spaceScanner.getAllMissions(MissionStatus.PARTIAL_FAILURE).size());
        assertEquals(0, spaceScanner.getAllMissions(MissionStatus.PRELAUNCH_FAILURE).size());

    }

    @Test
    void testGetCompanyWithMostSuccessfulMissionsValidDates() {
        assertEquals("CASC", spaceScanner.getCompanyWithMostSuccessfulMissions(
            LocalDate.of(2020, 4, 1), LocalDate.of(2020, 7, 1)));
    }

    @Test
    void testGetCompanyWithMostSuccessfulMissionsFromAfterTo() {
        assertThrows(TimeFrameMismatchException.class, () -> {
            spaceScanner.getCompanyWithMostSuccessfulMissions(
                LocalDate.of(2020, 7, 1), LocalDate.of(2020, 4, 1));
        });
    }

    @Test
    void testGetCompanyWithMostSuccessfulMissionsFromNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.getCompanyWithMostSuccessfulMissions(
                null, LocalDate.of(2020, 4, 1));
        });
    }

    @Test
    void testGetCompanyWithMostSuccessfulMissionsToNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.getCompanyWithMostSuccessfulMissions(
                LocalDate.of(2020, 4, 1), null);
        });
    }

    @Test
    void testGetCompanyWithMostSuccessfulMissionsNoMissions() {
        assertEquals("", spaceScanner.getCompanyWithMostSuccessfulMissions(
            LocalDate.of(2019, 1, 1), LocalDate.of(2019, 2, 1)));
    }

    @Test
    void testGetMissionsPerCountry() {
        assertEquals(9, spaceScanner.getMissionsPerCountry().size());
    }

    @Test
    void testGetTopNLeastExpensiveMissionsNLessThan0() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.getTopNLeastExpensiveMissions(-1, MissionStatus.SUCCESS, RocketStatus.STATUS_ACTIVE);
        });
    }

    @Test
    void testGetTopNLeastExpensiveMissionsMissionStatusNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.getTopNLeastExpensiveMissions(5, null, RocketStatus.STATUS_ACTIVE);
        });
    }

    @Test
    void testGetTopNLeastExpensiveMissionsRocketStatusNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.getTopNLeastExpensiveMissions(5, MissionStatus.SUCCESS, null);
        });
    }

    @Test
    void testGetTopNLeastExpensiveMissions() {
        assertEquals(5,
            spaceScanner.getTopNLeastExpensiveMissions(5, MissionStatus.SUCCESS, RocketStatus.STATUS_ACTIVE).size());
    }

    @Test
    void testFindMostOccurencesList() {
        List<String> list = new ArrayList<>() {{
            add("a");
            add("b");
            add("c");
            add("a");
            add("b");
            add("a");
        }};

        assertEquals("a", MJTSpaceScanner.findMostOccurencesList(list));
    }

    @Test
    void testGetMostDesiredLocationForMissionsPerCompany() {
        assertEquals(14, spaceScanner.getMostDesiredLocationForMissionsPerCompany().size());
    }

    @Test
    void testGetLocationWithMostSuccessfulMissionsPerCompanyValidDates() {
        assertEquals(9, spaceScanner.getLocationWithMostSuccessfulMissionsPerCompany(
            LocalDate.of(2020, 4, 1), LocalDate.of(2020, 7, 1)).size());
    }

    @Test
    void testGetLocationWithMostSuccessfulMissionsPerCompanyFromAfterTo() {
        assertThrows(TimeFrameMismatchException.class, () -> {
            spaceScanner.getLocationWithMostSuccessfulMissionsPerCompany(
                LocalDate.of(2020, 7, 1), LocalDate.of(2020, 4, 1));
        });
    }

    @Test
    void testGetLocationWithMostSuccessfulMissionsPerCompanyFromNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.getLocationWithMostSuccessfulMissionsPerCompany(
                null, LocalDate.of(2020, 4, 1));
        });
    }

    @Test
    void testGetLocationWithMostSuccessfulMissionsPerCompanyToNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.getLocationWithMostSuccessfulMissionsPerCompany(
                LocalDate.of(2020, 4, 1), null);
        });
    }

    @Test
    void testGetAllRockets() {
        assertEquals(49, spaceScanner.getAllRockets().size());
    }

    @Test
    void testGetTopNTallestRocketsNLessThan0() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.getTopNTallestRockets(-1);
        });
    }

    @Test
    void testGetTopNTallestRockets() {
        assertEquals(5, spaceScanner.getTopNTallestRockets(5).size());
    }

    @Test
    void testGetWikiPageForRocket() {
        assertEquals(49, spaceScanner.getWikiPageForRocket().size());
    }

    @Test
    void testGetWikiPagesForRocketsUsedInMostExpensiveMissionsNLessThan0() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.getWikiPagesForRocketsUsedInMostExpensiveMissions(-1, MissionStatus.SUCCESS,
                RocketStatus.STATUS_ACTIVE);
        });
    }

    @Test
    void testGetWikiPagesForRocketsUsedInMostExpensiveMissionsMissionStatusNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.getWikiPagesForRocketsUsedInMostExpensiveMissions(5, null, RocketStatus.STATUS_ACTIVE);
        });
    }

    @Test
    void testGetWikiPagesForRocketsUsedInMostExpensiveMissionsRocketStatusNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.getWikiPagesForRocketsUsedInMostExpensiveMissions(5, MissionStatus.SUCCESS, null);
        });
    }

    @Test
    void testGetWikiPagesForRocketsUsedInMostExpensiveMissions() {
        assertEquals(1, spaceScanner.getWikiPagesForRocketsUsedInMostExpensiveMissions(1, MissionStatus.SUCCESS,
            RocketStatus.STATUS_ACTIVE).size());
    }

    @Test
    void testSaveMostReliableRocketFromNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.saveMostReliableRocket(OutputStream.nullOutputStream(), null, LocalDate.of(2020, 4, 1));
        });
    }

    @Test
    void testSaveMostReliableRocketToNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.saveMostReliableRocket(OutputStream.nullOutputStream(), LocalDate.of(2020, 4, 1), null);
        });
    }

    @Test
    void testSaveMostReliableRocketFromAfterTo() {
        assertThrows(TimeFrameMismatchException.class, () -> {
            spaceScanner.saveMostReliableRocket(OutputStream.nullOutputStream(), LocalDate.of(2020, 7, 1),
                LocalDate.of(2020, 4, 1));
        });
    }

    @Test
    void testSaveMostReliableRocketOutputStreamNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.saveMostReliableRocket(null, LocalDate.of(2020, 4, 1), LocalDate.of(2020, 7, 1));
        });
    }

    @Test
    void testReturnMostReliableRocketFromNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.returnMostReliableRocket(OutputStream.nullOutputStream(), null, LocalDate.of(2020, 4, 1));
        });
    }

    @Test
    void testReturnMostReliableRocketToNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.returnMostReliableRocket(OutputStream.nullOutputStream(), LocalDate.of(2020, 4, 1), null);
        });
    }

    @Test
    void testReturnMostReliableRocketFromAfterTo() {
        assertThrows(TimeFrameMismatchException.class, () -> {
            spaceScanner.returnMostReliableRocket(OutputStream.nullOutputStream(), LocalDate.of(2020, 7, 1),
                LocalDate.of(2020, 4, 1));
        });
    }

    @Test
    void testReturnMostReliableRocketOutputStreamNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            spaceScanner.returnMostReliableRocket(null, LocalDate.of(2020, 4, 1), LocalDate.of(2020, 7, 1));
        });
    }

    @Test
    void testReturnMostReliableRocket() {
        assertEquals("H-IIA 202", spaceScanner.returnMostReliableRocket(System.out,
            LocalDate.of(2020, 4, 1), LocalDate.of(2020, 7, 1)));
    }

}
