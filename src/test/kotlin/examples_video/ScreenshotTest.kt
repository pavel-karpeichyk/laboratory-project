package examples_video

import com.google.sitebricks.client.Web
import com.sun.javafx.geom.Rectangle
import driver.Driver.Companion.getDriver
import driver.DriverType
import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.Point

import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import java.awt.Image
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.awt.image.PixelGrabber
import java.io.File
import java.util.*
import java.util.Arrays.equals
import javax.imageio.ImageIO
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class ScreenshotTest {
  enum class Result{MATCH,SIZE_MISMATCH,PIXEL_MISMATCH;}
var driver: WebDriver?=null
  fun createScreenshot(driver: WebDriver, element: WebElement): File {
    //var s: TakesScreenshot = (driver as TakesScreenshot?)!!
    var screenshot: File = (driver as TakesScreenshot?)!!.getScreenshotAs(OutputType.FILE)
    var image: BufferedImage= ImageIO.read(screenshot)
    var width: Int = element.size.width
    var height: Int = element.size.height

    val rectangle: Rectangle = Rectangle(width, height)
    var point:Point = element.location

    var dest: BufferedImage= image.getSubimage(point.getX(), point.getY(), rectangle.width, rectangle.height)
    ImageIO.write(dest, "png", screenshot)

    return  screenshot
  }

  @Test
  fun`screenshot test`(){
    driver=getDriver(DriverType.CHROME)
    driver?.manage()?.window()?.maximize()
    driver?.get("https://yandex.by/search/?text=%D0%BA%D1%80%D0%B0%D1%81%D0%B8%D0%B2%D1%8B%D0%B5+%D0%BA%D0%B0%D1%80%D1%82%D0%B8%D0%BD%D0%BA%D0%B8&lr=157&clid=2411726")
 val photo: WebElement = driver!!.findElement(By.xpath("//div[@id='135d5b36a23b1eaf80aebd5fd6e1e66b-4662446-images-thumbs']"))
   FileUtils.copyFile(createScreenshot(driver!!, photo, ),
     File(".//target/screenshots/"+ ".png"))

  }

  fun compareImages (baseFile: String, actualFile: String): Result{
    var compareResult: Result= Result.PIXEL_MISMATCH
    var baseImage: Image= Toolkit.getDefaultToolkit().getImage(baseFile)
    var actualImage: Image= Toolkit.getDefaultToolkit().getImage(actualFile)

    var baseImageGrab: PixelGrabber= PixelGrabber(baseImage,0,0,-1,-1,false)
    var actualImageGrab: PixelGrabber=PixelGrabber(actualImage,0,0,-1,-1,false)
       var baseImageData: Array<Any>? = null
    var actualImageData: Array<Any>? = null
    if(baseImageGrab.grabPixels()){
     baseImageData = arrayOf(baseImageGrab.pixels as Any)
    }

    if(actualImageGrab.grabPixels()){
      actualImageData = arrayOf(actualImageGrab.pixels as Any)
    }

    if((baseImageGrab.height!= actualImageGrab.height) || (baseImageGrab.width != actualImageGrab.width)){
      compareResult=Result.SIZE_MISMATCH
    }else if (baseImageData.contentEquals(actualImageData)){
      compareResult= Result.MATCH

    }
    return compareResult


  }

}