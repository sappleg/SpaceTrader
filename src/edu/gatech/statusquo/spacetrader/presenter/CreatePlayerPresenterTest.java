package edu.gatech.statusquo.spacetrader.presenter;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.*;

import edu.gatech.statusquo.spacetrader.model.Player;
import edu.gatech.statusquo.spacetrader.view.CreatePlayerView;
import junit.framework.TestCase;

/**
 * The class <code>CreatePlayerPresenterTest</code> contains tests for the
 * class {@link <code>CreatePlayerPresenter</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 11/13/12 12:37 PM
 *
 * @author spencer
 *
 * @version $Revision$
 */
public class CreatePlayerPresenterTest extends TestCase {
	private Player player;
	private CreatePlayerView createPlayerView;
	private CreatePlayerPresenter createPlayerPresenter;
    private Collection<Object> collection;

	/**
	 * Construct new test instance
	 *
	 * @param name the test name
	 */
	public CreatePlayerPresenterTest(String name) {
		super(name);
        Player player = new Player();
//      CreatePlayerView createPlayerView = new CreatePlayerView();
        
	}

    @Test
    public void testCalculatePoints() {
    	CreatePlayerPresenter createPlayerPresenter = new CreatePlayerPresenter(createPlayerView, player);
        assertEquals(15,createPlayerPresenter.calculatePoints());
        createPlayerPresenter.engineerUsed = -1;
        createPlayerPresenter.fighterUsed = -1;
        createPlayerPresenter.pilotUsed = -1;
        createPlayerPresenter.traderUsed = -1;
        assertEquals(19,createPlayerPresenter.calculatePoints());
        createPlayerPresenter.engineerUsed = 1;
        createPlayerPresenter.fighterUsed = 1;
        createPlayerPresenter.pilotUsed = 1;
        createPlayerPresenter.traderUsed = 1;
        assertEquals(11,createPlayerPresenter.calculatePoints());
        createPlayerPresenter.engineerUsed = 10;
        createPlayerPresenter.fighterUsed = 10;
        createPlayerPresenter.pilotUsed = 10;
        createPlayerPresenter.traderUsed = 10;
        assertEquals(-25,createPlayerPresenter.calculatePoints());
        createPlayerPresenter.engineerUsed = 10;
        createPlayerPresenter.fighterUsed = 10;
        createPlayerPresenter.pilotUsed = 10;
        createPlayerPresenter.traderUsed = 10;
    }
    
    @Test
    public void testCheckValidityConditionalFalse() {
    	CreatePlayerPresenter createPlayerPresenter = new CreatePlayerPresenter(createPlayerView, player);
        createPlayerPresenter.engineerUsed = 10;
        createPlayerPresenter.fighterUsed = 10;
        createPlayerPresenter.pilotUsed = 10;
        createPlayerPresenter.traderUsed = 10;
        createPlayerPresenter.checkValidityOfPoints();
        assertEquals(15, createPlayerPresenter.pointsAvailable);
        assertEquals(0, createPlayerPresenter.engineerUsed);
        assertEquals(0, createPlayerPresenter.fighterUsed);
        assertEquals(0, createPlayerPresenter.pilotUsed);
        assertEquals(0, createPlayerPresenter.traderUsed);
        assertEquals(true, createPlayerPresenter.status);
        assertEquals(true, createPlayerPresenter.checkValidityOfPoints());
    }
    
    @Test
    public void testCheckValidityConditionalTrue() {
    	CreatePlayerPresenter createPlayerPresenter = new CreatePlayerPresenter(createPlayerView, player);
        createPlayerPresenter.engineerUsed = 0;
        createPlayerPresenter.fighterUsed = 0;
        createPlayerPresenter.pilotUsed = 0;
        createPlayerPresenter.traderUsed = 0;
        createPlayerPresenter.checkValidityOfPoints();
        assertEquals(15, createPlayerPresenter.pointsAvailable);
        assertEquals(true, createPlayerPresenter.status);
        assertEquals(true, createPlayerPresenter.checkValidityOfPoints());
    }
}

/*$CPS$ This comment was generated by CodePro. Do not edit it.
 * patternId = com.instantiations.assist.eclipse.pattern.testCasePattern
 * strategyId = com.instantiations.assist.eclipse.pattern.testCasePattern.junitTestCase
 * additionalTestNames = 
 * assertTrue = false
 * callTestMethod = true
 * createMain = true
 * createSetUp = false
 * createTearDown = false
 * createTestFixture = false
 * createTestStubs = false
 * methods = 
 * package = edu.gatech.statusquo.spacetrader.presenter
 * package.sourceFolder = SpaceTrader/src
 * superclassType = junit.framework.TestCase
 * testCase = CreatePlayerPresenterTest
 * testClassType = CreatePlayerPresenter
 */