package controllers.my.upload.ner

import akka.actor.Props
import controllers.my.upload.SupervisorActor
import java.io.File
import models.generated.tables.records.{ DocumentRecord, DocumentFilepartRecord }
import scala.concurrent.duration.FiniteDuration

private[ner]
  class NERSupervisorActor(document: DocumentRecord, parts: Seq[DocumentFilepartRecord], dir: File, keepalive: FiniteDuration) 
  extends SupervisorActor(document, parts, dir, keepalive) {

  /** Creates workers for every content type indicated as 'supported' by the Worker class **/
  override def spawnWorkers(document: DocumentRecord, parts: Seq[DocumentFilepartRecord], dir: File) =
    parts
      .filter(part => NERWorkerActor.SUPPORTED_CONTENT_TYPES.contains(part.getContentType))
      .map(p => context.actorOf(Props(classOf[NERWorkerActor], document, p, dir), name="doc_" + document.getId + "_part" + p.getId))

}


