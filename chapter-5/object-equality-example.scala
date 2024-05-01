object App:
  def main(args: Array[String]): Unit =
    assert(!(1 == 2))
    assert(1 != 2)
    assert(2 == 2)

    assert(List(1, 2, 3) == List(1, 2, 3))
    assert(!(List(1, 2, 3) == List(4, 5, 6)))

    assert(1 == 1.0 )

    assert(!(List(1, 2, 3) == null))
    assert(!(null == List(1, 2, 3)))

    assert(("he" + "llo") == "hello")
