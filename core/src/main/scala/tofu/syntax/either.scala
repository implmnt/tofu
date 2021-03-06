package tofu.syntax

object either {
  implicit final class AssocLOps[A, B, C](private val e: Either[Either[A, B], C]) extends AnyVal {
    def assocL: Either[A, Either[B, C]] = e match {
      case Left(Left(a))  => Left(a)
      case Left(Right(b)) => Right(Left(b))
      case Right(c)       => Right(Right(c))
    }
  }

  implicit final class AssocROps[A, B, C](private val e: Either[A, Either[B, C]]) extends AnyVal {
    def assocR: Either[Either[A, B], C] = e match {
      case Left(a)         => Left(Left(a))
      case Right(Left(b))  => Left(Right(b))
      case Right(Right(c)) => Right(c)
    }
  }
}
