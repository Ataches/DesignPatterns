package visitor;

public interface VisitorInterface {
  double visit(NonCaliforniaOrder nco);
  double visit(CaliforniaOrder co);
  double visit(OverseasOrder oo);
  double visit(ChineseOrder chno);
}
