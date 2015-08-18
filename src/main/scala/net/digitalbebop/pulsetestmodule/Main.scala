package net.digitalbebop.pulsetestmodule

import com.google.protobuf.ByteString
import net.digitalbebop.ClientRequests.IndexRequest
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ByteArrayEntity
import org.apache.http.impl.client.HttpClients

object Main {

  def main(args: Array[String]): Unit = {
    val address = if (args.length > 0) args(0) else "http://localhost:8080"
    println(s"using address: $address, specify in arguments to override")

    val builder = IndexRequest.newBuilder()
    print("Module Name: ")
    builder.setModuleName(readLine())

    print("Module Id: ")
    builder.setModuleId(readLine())

    print("Tags (separated by ','): ")
    readLine().split(",").foreach(builder.addTags)

    print("Username: ")
    builder.setUsername(readLine())

    print("Meta tags: ")
    builder.setMetaTags(readLine())

    print("Index data: ")
    builder.setIndexData(readLine())

    print("Raw data: ")
    builder.setRawData(ByteString.copyFrom(readLine().getBytes))

    val post = new HttpPost(s"$address/api/index")
    post.setEntity(new ByteArrayEntity(builder.build().toByteArray))
    val response = HttpClients.createDefault().execute(post)
    println(response)
  }
}
